package med.cld.api.domain.appointment.validations;

import med.cld.api.domain.appointment.ScheduleAppointmentData;

public interface ValidatorAppointmentSchedule {
  void validate(ScheduleAppointmentData data);
}
