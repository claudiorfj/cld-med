package med.cld.api.domain.appointment.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.cld.api.domain.appointment.AppointmentRepository;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

@Component
public class ValidatorDoctorAlreadyScheduled implements ValidatorAppointmentSchedule{
  
  @Autowired
  private AppointmentRepository repository;

  public void validate(ScheduleAppointmentData data) {
    var doctorAlreadyScheduledAtSameTime = repository.existsByDoctorIdAndDate(data.idDoctor(), data.date());
    if(doctorAlreadyScheduledAtSameTime){
      throw new ValidationException("Doctor already has another appointment scheduled at the same time");
    }
  }

}
