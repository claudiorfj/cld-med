package med.cld.api.domain.appointment.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;
import med.cld.api.domain.doctor.DoctorRepository;

@Component
public class ValidatorActiveDoctor implements ValidatorAppointmentSchedule{
  
  @Autowired
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
