package med.cld.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.cld.api.domain.address.AddressData;

public record RegisterPatientData(

  @NotBlank(message = "{name.required}")
  String name,

  String sex, 

  @NotBlank(message = "{cpf.required}")
  @Pattern(regexp = "\\d{11}", message = "{cpf.invalid}")
  String cpf, 

  @NotBlank(message = "{email.required}")
  @Email(message = "{email.invalid}")
  String email, 

  @NotBlank(message = "{phone.required}")
  String phone, 
  
  @NotNull(message = "{address.required}")
  @Valid
  AddressData address) {

}
