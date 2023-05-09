package med.cld.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.cld.api.doctor.RegisterDoctorData;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
  
  @PostMapping
  public void register(@RequestBody RegisterDoctorData data) {
    System.out.println(data);
  }

}
