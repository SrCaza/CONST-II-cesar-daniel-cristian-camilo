package app.domain.ports.out;

import java.util.List;

import app.domain.model.Patient;
import app.domain.services.DoctorService;

public interface DoctorRepository {
	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord);
	public void deleteMedicalRecord(long id, DoctorService deleteMedicalRecord);
	public List<Patient>findAllPatient(DoctorService findPatients);
	public List<Patient>searchPatientById(DoctorService searchPatient);
}
