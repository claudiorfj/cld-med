package med.cld.api.domain.appointment.validations;

import java.time.DayOfWeek;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

public class ValidatorOpeningHoursClinic {
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
