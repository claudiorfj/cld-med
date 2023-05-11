package med.cld.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;
import med.cld.api.domain.patient.PatientRepository;

public class ValidatorPatientIsActive {
  
  private PatientRepository repository;

  public void validate(ScheduleAppointmentData data) {
    var patientIsActive = repository.findActiveById(data.idPatient());
    if(!patientIsActive) {
      throw new ValidationException("Appointment cannot be scheduled with excluded patient");
    }
  }

}
