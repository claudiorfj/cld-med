package med.cld.api.domain.patient;

public record ListPatientData(
  String name,
  String cpf,
  String email
) {

  public ListPatientData(Patient patient) {
    this(patient.getName(),
    patient.getCpf(),
    patient.getEmail()
    );
  }

}
