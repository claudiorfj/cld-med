package med.cld.api.patient;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.cld.api.address.Address;

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

  @Embedded
  private Address address;

  public Patient(RegisterPatientData data) {
    this.name = data.name();
    this.sex = data.sex();
    this.cpf = data.cpf();
    this.email = data.email();
    this.phone = data.phone();
    this.address = new Address(data.address());
  }
}
