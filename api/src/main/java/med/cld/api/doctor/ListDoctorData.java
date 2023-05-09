package med.cld.api.doctor;

public record ListDoctorData(
  String name,
  String email,
  String crm,
  Specialty specialty
) {
  public ListDoctorData(Doctor doctor) {
    this(doctor.getName(), 
      doctor.getEmail(),
      doctor.getCrm(),
      doctor.getSpecialty()
    );
  }
}
