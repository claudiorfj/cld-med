CREATE TABLE appointment(

  id BIGINT NOT NULL auto_increment, 
  doctor_id BIGINT NOT NULL,
  patient_id BIGINT NOT NULL,
  date datetime NOT NULL,

  PRIMARY KEY(id),
  CONSTRAINT fk_appointment_doctor_id FOREIGN KEY(doctor_id) REFERENCES doctors(id),
  CONSTRAINT fk_appointment_patient_id FOREIGN KEY(patient_id) REFERENCES patients(id)
)