package med.cld.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.cld.api.doctor.Doctor;
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
  public void register(@RequestBody @Valid RegisterDoctorData data) {
    repository.save(new Doctor(data));
  }

  @GetMapping
  public Page<ListDoctorData> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
    return repository.findAllByActiveTrue(pagination).map(ListDoctorData::new);
  }

  @PutMapping
  @Transactional
  public void update(@RequestBody @Valid UpdateDoctorData data){
    var doctor = repository.getReferenceById(data.id());
    doctor.updateData(data);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void delete(@PathVariable Long id) {
    var doctor = repository.getReferenceById(id);
    doctor.delete();
  }
}
