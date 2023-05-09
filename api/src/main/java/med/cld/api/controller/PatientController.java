package med.cld.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.cld.api.patient.ListPatientData;
import med.cld.api.patient.Patient;
import med.cld.api.patient.PatientRepository;
import med.cld.api.patient.RegisterPatientData;

@RestController
@RequestMapping("/patients")
public class PatientController {

  @Autowired
  private PatientRepository repository;
  
  @PostMapping
  @Transactional
  public void register(@RequestBody @Valid RegisterPatientData data) {
    repository.save(new Patient(data));
  }

    @GetMapping
  public Page<ListPatientData> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
    return repository.findAll(pagination).map(ListPatientData::new);
  }

}
