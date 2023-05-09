package med.cld.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private String street;
  private String district;
  private String zipCode;
  private String city;
  private String state;
  private String complement;
  private String number;

  public Address(AddressData data) {
    this.street = data.street();
    this.city = data.city();
    this.complement = data.complement();
    this.district = data.district();
    this.number = data.number();
    this.state = data.state();
    this.zipCode = data.zipCode();
  }

}
