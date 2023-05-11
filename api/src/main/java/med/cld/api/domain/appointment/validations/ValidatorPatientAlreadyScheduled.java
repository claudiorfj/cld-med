package med.cld.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.AppointmentRepository;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

public class ValidatorPatientAlreadyScheduled {
  
  private AppointmentRepository repository;

  public void validate(ScheduleAppointmentData data){
    var firstSchedule = data.date().withHour(7);
    var lastSchedule = data.date().withHour(18);
    var patientAlreadyScheduledAtSameDay = repository.existsByPatientIdAndDateBetween(data.idPatient(), firstSchedule, lastSchedule);
    if (patientAlreadyScheduledAtSameDay) {
      throw new ValidationException("Patient already has an appointment scheduled in this same day");
    }
  }

}
