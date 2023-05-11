package med.cld.api.domain.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.cld.api.domain.ExceptionValidation;
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

  public void toSchedule (ScheduleAppointmentData data) {
    if(!patientRepository.existsById(data.idPatient())){
      throw new ExceptionValidation("ID Patient not found");
    }
    if(data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())){
      throw new ExceptionValidation("ID Doctor not found");
    }
    var doctor = doctorRepository.getReferenceById(data.idDoctor());
    var patient = selectDoctor(data);
    var appointment = new Appointment(null, doctor, patient, data.date());
    appointmentRepository.save(appointment);
  }

  private Doctor selectDoctor(ScheduleAppointmentData data) {
    if(data.idDoctor() != null) {
      return doctorRepository.getReferenceById(data.idDoctor());
    }

    if (data.specialty() == null) {
      throw new ExceptionValidation("Specialty is mandatory if you don't choose a doctor");
    }

    return doctorRepository.chooseFreeDoctor(data.specialty(), data.date());

  }
  
}
