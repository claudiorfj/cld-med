package med.cld.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.cld.api.doctor.Doctor;
import med.cld.api.doctor.DoctorDetailData;
import med.cld.api.doctor.DoctorRepository;
import med.cld.api.doctor.ListDoctorData;
import med.cld.api.doctor.RegisterDoctorData;
import med.cld.api.doctor.UpdateDoctorData;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

  @Autowired
  private DoctorRepository repository;
  
  @PostMapping
  @Transactional
  public ResponseEntity register(@RequestBody @Valid RegisterDoctorData data, UriComponentsBuilder uriBuilder) {
    var doctor = new Doctor(data);
    repository.save(doctor);
    var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
    return ResponseEntity.created(uri).body(new DoctorDetailData(doctor));
  }

  @GetMapping
  public ResponseEntity<Page<ListDoctorData>> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
    var page = repository.findAllByActiveTrue(pagination).map(ListDoctorData::new);
    return ResponseEntity.ok(page);
  }

  @PutMapping
  @Transactional
  public ResponseEntity update(@RequestBody @Valid UpdateDoctorData data){
    var doctor = repository.getReferenceById(data.id());
    doctor.updateData(data);
    return ResponseEntity.ok(new DoctorDetailData(doctor));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity delete(@PathVariable Long id) {
    var doctor = repository.getReferenceById(id);
    doctor.delete();
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity detail(@PathVariable Long id) {
    var doctor = repository.getReferenceById(id);
    doctor.delete();
    return ResponseEntity.noContent().build();
  }
}
