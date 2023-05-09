package med.cld.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.cld.api.doctor.Doctor;
import med.cld.api.doctor.DoctorRepository;
import med.cld.api.doctor.ListDoctorData;
import med.cld.api.doctor.RegisterDoctorData;

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
  public List<ListDoctorData> listing() {
    return repository.findAll().stream().map(ListDoctorData::new).toList();
  }

}
