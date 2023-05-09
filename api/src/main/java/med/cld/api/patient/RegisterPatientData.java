package med.cld.api.patient;

import med.cld.api.address.AddressData;

public record RegisterPatientData(String name, String dateOfBirth, String sex, String email, String phoneNumber, String idPatient, AddressData address) {

}
