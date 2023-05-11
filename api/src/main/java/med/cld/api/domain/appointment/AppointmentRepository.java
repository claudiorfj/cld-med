package med.cld.api.domain.appointment;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

  boolean existsByPatientIdAndDateBetween(Long idPatient, LocalDateTime firstSchedule, LocalDateTime lastSchedule);

  boolean existsByDoctorIdAndDate(Long idDoctor, LocalDateTime date);
  
}
