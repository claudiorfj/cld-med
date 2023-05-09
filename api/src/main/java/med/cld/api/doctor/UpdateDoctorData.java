package med.cld.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.cld.api.address.AddressData;

public record UpdateDoctorData(
  
  @NotNull
  Long id,
  String name,
  String phone,
  AddressData address
  ) {
  
}
