package med.cld.api.domain.appointment.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

public class ValidatorScheduleInAdvance {
  public void validate(ScheduleAppointmentData data){
    var appointmentDate = data.date();
    var now = LocalDateTime.now();
    var differenceInMinutes = Duration.between(now, appointmentDate).toMinutes();
    if (differenceInMinutes < 30) {
      throw new ValidationException("The appointment must be scheduled 30 minutes in advance");
    }
  }
}
