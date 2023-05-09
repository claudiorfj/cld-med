package med.cld.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.cld.api.doctor.Doctor;
import med.cld.api.doctor.DoctorRepository;
import med.cld.api.doctor.RegisterDoctorData;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

  @Autowired
  private DoctorRepository repository;
  
  @PostMapping
  public void register(@RequestBody RegisterDoctorData data) {
    repository.save(new Doctor(data));
  }

}
