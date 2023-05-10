package med.cld.api.domain.patient;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.cld.api.domain.address.Address;

@Table(name = "patient")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String sex;
  private String cpf;
  private String email;
  private String phone;
  private Boolean active;

  @Embedded
  private Address address;

  public Patient(RegisterPatientData data) {
    this.active = true;
    this.name = data.name();
    this.sex = data.sex();
    this.cpf = data.cpf();
    this.email = data.email();
    this.phone = data.phone();
    this.address = new Address(data.address());
  }
  public void updateData(@Valid UpdatePatientData data) {
    if (data.name() != null){
      this.name = data.name();
    }
    if (data.phone() != null){
      this.phone = data.phone();
    }
    if (data.address() != null){
      this.address.updateData(data.address());
    }
  }

  public void delete() {
    this.active = false;
  }

}

