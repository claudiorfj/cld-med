package med.cld.api.patient;

import med.cld.api.address.Address;

public record PatientDetailData(
  Long id,
  String name,
  String sex,
  String cpf,
  String email,
  String phone,
  Address address
) {
  
  public PatientDetailData(Patient patient) {
    this(patient.getId(), patient.getName(), patient.getSex(), patient.getCpf(), patient.getEmail(), patient.getPhone(), patient.getAddress());
  }

}