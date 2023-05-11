package med.cld.api.domain.appointment.validations;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

@Component
public class ValidatorOpeningHoursClinic implements ValidatorAppointmentSchedule{
  public void validate(ScheduleAppointmentData data){
    var appointmentDate = data.date();
    var sunday = appointmentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    var beforeOpening = appointmentDate.getHour() < 7;
    var afterClosing = appointmentDate.getHour() > 18;
    if (sunday || beforeOpening || afterClosing) {
      throw new ValidationException("The Appointment is outside the clinic's business hours");
    }
  }
}
