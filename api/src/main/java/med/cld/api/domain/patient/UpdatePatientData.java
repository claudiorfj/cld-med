package med.cld.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.cld.api.domain.address.AddressData;

public record UpdatePatientData(
  
  @NotNull
  Long id,
  String name,
  String phone,
  AddressData address
) {

}
