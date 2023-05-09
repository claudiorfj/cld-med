package med.cld.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.cld.api.address.AddressData;

public record RegisterPatientData(

  @NotBlank
  String name,

  String sex, 

  @NotBlank
  @Pattern(regexp = "\\d{11}")
  String cpf, 

  @NotBlank
  @Email
  String email, 

  @NotBlank
  String phone, 
  
  @NotNull
  @Valid
  AddressData address) {

}
