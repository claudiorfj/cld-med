package med.cld.api.domain.appointment;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import med.cld.api.domain.doctor.Doctor;
import med.cld.api.domain.patient.Patient;

public class Appointment {
  
  public Appointment(Object object, Doctor doctor2, Patient patient2, LocalDateTime date2) {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  private Patient patient;

  private LocalDateTime date;
}
