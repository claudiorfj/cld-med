package med.cld.api.doctor;

import med.cld.api.address.Address;
import java.util.Objects;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String crm;
  private String phone;

  @Enumerated(EnumType.STRING)
  private Specialty specialty;
  
  @Embedded
  private Address address;

  public Doctor(RegisterDoctorData data) {
    this.name = data.name();
    this.email = data.email();
    this.crm = data.crm();
    this.specialty = data.specialty();
    this.phone = data.phone();
    this.address = new Address(data.address());
  }

}
