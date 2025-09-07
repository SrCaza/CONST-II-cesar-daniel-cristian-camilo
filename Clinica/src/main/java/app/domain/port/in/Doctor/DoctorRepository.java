package app.domain.port.in.Doctor;

import java.util.List;

import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;
import app.domain.valueobject.Id;

public interface DoctorRepository {
	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord);
	public void deleteMedicalRecord(long id, DoctorService deleteMedicalRecord);
	public List<Patient>findAllPatient(DoctorService findPatients);
	public List<Patient>searchPatientById(DoctorService searchPatient);
	public List<MedicalRecord>searchMedicalRecord(Id searchMedicalRecord);
	public void deletePatient(Id deletePatient);
}
