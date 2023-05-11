package med.cld.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.cld.api.domain.appointment.ScheduleAppointment;
import med.cld.api.domain.appointment.ScheduleAppointmentData;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

  private ScheduleAppointment schedule;

  @PostMapping
  @Transactional
  public ResponseEntity schedule (@RequestBody @Valid ScheduleAppointmentData data) {
    var dto = schedule.toSchedule(data);
    return ResponseEntity.ok(dto);
  } 
  
}
