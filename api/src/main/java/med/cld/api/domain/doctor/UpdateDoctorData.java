package med.cld.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.cld.api.domain.address.AddressData;

public record UpdateDoctorData(
  
  @NotNull
  Long id,
  String name,
  String phone,
  AddressData address
  ) {
  
}
