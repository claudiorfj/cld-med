package med.cld.api.domain.appointment;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ScheduleAppointmentData(
  
  Long idDoctor,

  @NotNull
  Long idPatient,

  @NotNull
  @Future
  LocalDate data) {

}
