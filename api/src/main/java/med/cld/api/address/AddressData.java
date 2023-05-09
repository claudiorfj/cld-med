package med.cld.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(

  @NotBlank
  String street, 

  @NotBlank
  String district, 

  @NotBlank
  @Pattern(regexp = "\\d{8}")
  String zipCode, 

  @NotBlank
  String city, 

  @NotBlank
  String state, 

  String complement, 

  String number) {
  
}
