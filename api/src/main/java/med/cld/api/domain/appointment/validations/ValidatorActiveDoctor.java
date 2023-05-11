package med.cld.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;
import med.cld.api.domain.doctor.DoctorRepository;

public class ValidatorActiveDoctor {
  
  private DoctorRepository repository;

  public void validate(ScheduleAppointmentData data) {
    if(data.idDoctor() == null) {
      return;
    }
    var doctorIsActive = repository.findActiveById(data.idDoctor());
    if(!doctorIsActive) {
      throw new ValidationException("Schedule an appointment cannot be done with a excluded doctor");
    }
  }

}
