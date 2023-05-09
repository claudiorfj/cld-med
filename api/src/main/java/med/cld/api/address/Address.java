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

  public void updateData(AddressData data) {
    if (data.street() != null){
      this.street = data.street();
    }
    if (data.district() != null){
      this.district = data.district();
    }
    if (data.zipCode() != null){
      this.zipCode = data.zipCode();
    }
    if (data.state() != null){
      this.state = data.state();
    }
    if (data.city() != null){
      this.city = data.city();
    }
    if (data.number() != null){
      this.number = data.number();
    }
    if (data.complement() != null){
      this.complement = data.complement();
    }

  }

}
