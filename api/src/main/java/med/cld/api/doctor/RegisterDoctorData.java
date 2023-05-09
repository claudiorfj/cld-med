package med.cld.api.doctor;

import med.cld.api.address.AddressData;

public record RegisterDoctorData(String name, String email, String crm, Specialty specialty, AddressData address) {
  
}
