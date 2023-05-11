package med.cld.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.AppointmentRepository;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

public class ValidatorDoctorAlreadyScheduled {
  
  private AppointmentRepository repository;

  public void validate(ScheduleAppointmentData data) {
    var doctorAlreadyScheduledAtSameTime = repository.existsByDoctorIdAndDate(data.idDoctor(), data.date());
    if(doctorAlreadyScheduledAtSameTime){
      throw new ValidationException("Doctor already has another appointment scheduled at the same time");
    }
  }

}
