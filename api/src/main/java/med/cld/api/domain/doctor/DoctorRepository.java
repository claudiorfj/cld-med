package med.cld.api.domain.doctor;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

  Page<Doctor> findAllByActiveTrue(Pageable pagination);

  @Query("""
      select d from Doctor d
      where
      d.active = 1
      and
      d.specialty = :specialty
      and
      d.id not in(
        select a.doctor.id from Appointment a
        where
        a.data = :date
      )
      order by rand()
      limit 1
      """)
  Doctor chooseFreeDoctor(Specialty specialty, LocalDateTime date);

  @Query("""
      select d.active
      from Doctor d
      where d.id = :id
      """)
  Boolean findActiveById(Long idDoctor);
  
}
