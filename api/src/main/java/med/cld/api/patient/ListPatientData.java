package med.cld.api.patient;

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
