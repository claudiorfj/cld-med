package med.cld.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.cld.api.patient.RegisterPatientData;

@RestController
@RequestMapping("/patients")
public class PatientController {
  
  @PostMapping
  public void register(@RequestBody RegisterPatientData data) {
    System.out.println(data);
  }

}
