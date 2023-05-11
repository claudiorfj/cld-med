package med.cld.api.domain.appointment;

import java.time.LocalDateTime;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.cld.api.domain.doctor.Specialty;

public record ScheduleAppointmentData(
  
  Long idDoctor,

  @NotNull
  Long idPatient,

  @Future
  @NotNull
  LocalDateTime date,
  
  Specialty specialty

  ) {

}
