package med.cld.api.domain.appointment.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

@Component
public class ValidatorCancelInAdvance implements ValidatorAppointmentSchedule{
  public void validate(ScheduleAppointmentData data){
    var appointmentDate = data.date();
    var now = LocalDateTime.now();
    var differenceInHours = Duration.between(now, appointmentDate).toHours();
    if (differenceInHours < 24) {
      throw new ValidationException("The appointment cancellation must be done at least 24 hours before the appointment");
    }
  }
}
