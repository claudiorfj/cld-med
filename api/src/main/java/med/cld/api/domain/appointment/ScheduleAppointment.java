package med.cld.api.domain.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.cld.api.domain.ExceptionValidation;
import med.cld.api.domain.appointment.validations.ValidatorAppointmentSchedule;
import med.cld.api.domain.doctor.Doctor;
import med.cld.api.domain.doctor.DoctorRepository;
import med.cld.api.domain.patient.PatientRepository;

@Service
public class ScheduleAppointment {

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private PatientRepository patientRepository;

  private List<ValidatorAppointmentSchedule> validators;

  public AppointmentDetailData toSchedule(ScheduleAppointmentData data) {
    if (!patientRepository.existsById(data.idPatient())) {
      throw new ExceptionValidation("ID Patient not found");
    }
    if (data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
      throw new ExceptionValidation("ID Doctor not found");
    }
    validators.forEach(v -> v.validate(data));
    
    var doctor = doctorRepository.getReferenceById(data.idDoctor());
    var patient = selectDoctor(data);
    if(doctor == null){
      throw new ExceptionValidation("There are no doctors available");
    }
    var appointment = new Appointment(null, doctor, patient, data.date());
    appointmentRepository.save(appointment);
    return new AppointmentDetailData(appointment);
  }

  private Doctor selectDoctor(ScheduleAppointmentData data) {
    if (data.idDoctor() != null) {
      return doctorRepository.getReferenceById(data.idDoctor());
    }
    if (data.specialty() == null) {
      throw new ExceptionValidation("Specialty is mandatory if you don't choose a doctor");
    }
    return doctorRepository.chooseFreeDoctor(data.specialty(), data.date());

  }

}
