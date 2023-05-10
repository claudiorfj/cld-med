package med.cld.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.cld.api.domain.address.AddressData;

public record RegisterDoctorData(

  @NotBlank(message = "{name.required}")
  String name,

  @NotBlank(message = "{email.required}")
  @Email(message = "{email.invalid}")
  String email, 

  @NotBlank(message = "{phone.required}")
  String phone,

  @NotBlank(message = "{crm.required}")
  @Pattern(regexp = "\\d{4,6}", message = "{crm.invalid}")
  String crm, 

  @NotNull(message = "{specialty.required}")
  Specialty specialty, 

  @NotNull(message = "{address.required}")
  @Valid
  AddressData address) {
  
}
