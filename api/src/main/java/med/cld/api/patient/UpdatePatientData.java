package med.cld.api.patient;

import jakarta.validation.constraints.NotNull;
import med.cld.api.address.AddressData;

public record UpdatePatientData(
  
  @NotNull
  Long id,
  String name,
  String phone,
  AddressData address
) {

}
