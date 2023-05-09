package med.cld.api.doctor;

import med.cld.api.address.AddressData;

public record DoctorDetailData(
  Long id,
  String name,
  String email,
  String crm,
  String phone,
  Specialty specialty,
  AddressData address
) {
  
  public DoctorDetailData(Doctor doctor) {
    this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddressData());
  }

}
