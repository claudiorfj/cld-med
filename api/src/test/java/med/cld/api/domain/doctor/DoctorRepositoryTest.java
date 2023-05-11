package med.cld.api.domain.doctor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import med.cld.api.domain.address.AddressData;
import med.cld.api.domain.appointment.Appointment;
import med.cld.api.domain.patient.Patient;
import med.cld.api.domain.patient.RegisterPatientData;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DoctorRepositoryTest {

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private TestEntityManager em;

  @Test
  @DisplayName("Should return null when the only registered doctor is not avaiable for the date")
  void testChooseFreeDoctor() {
    var nextMondayAt10 = LocalDate.now()
      .with(TemporalAdjuster.next(DayOfWeek.MONDAY))
      .atTime(10, 0);

    var doctor = registerDoctor("doctor", "doctor@cld.med", "123456", "CARDIOLOGIST");
    var patient = registerPatient("patient", "patient@cld.med", "00000000000");
    registerAppointment(doctor, patient, nextMondayAt10);

    var avaiableDoctor = doctorRepository.chooseFreeDoctor(Specialty.CARDIOLOGY, nextMondayAt10);
    assertThat(avaiableDoctor).isNull();

  }

  private void registerAppointment(Doctor doctor, Patient patient, LocalDateTime date) {
    em.persist(new Appointment(null, doctor, patient, date, null));
}

private Doctor registerDoctor(String name, String email, String crm, Specialty specialty) {
    var medico = new Doctor(RegisterDoctorData(name, email, crm, specialty));
    em.persist(medico);
    return medico;
}

private Patient registerPatient(String name, String email, String cpf) {
    var patient = new Patient(RegisterPatientData(name, email, cpf));
    em.persist(patient);
    return patient;
}

private RegisterDoctorData RegisterDoctorData(String name, String email, String crm, Specialty specialty) {
    return new RegisterDoctorData(
            name,
            email,
            "61999999999",
            crm,
            specialty,
            AddressData()
    );
}

private RegisterPatientData RegisterPatientData(String name, String email, String cpf) {
    return new RegisterPatientData(
            name,
            email,
            "61999999999",
            cpf,
            cpf, AddressData()
    );
}

private AddressData AddressData() {
    return new AddressData(
            "rua xpto",
            "bairro",
            "00000000",
            "Brasilia",
            "DF",
            null,
            null
    );
}

}
