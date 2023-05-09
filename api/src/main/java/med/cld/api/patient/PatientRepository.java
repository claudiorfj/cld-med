package med.cld.api.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
  
  Page<Patient> findAllByActiveTrue(org.springframework.data.domain.Pageable pagination);


}
