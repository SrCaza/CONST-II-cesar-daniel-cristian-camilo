package app.domain.port.in.patient;

import app.domain.port.in.Doctor.DoctorService;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface PatientRepository {
	public void createPatient(Patient patient);
	public void deletePatient(Id patientId);
	public List<Patient> findPatientById(Id patientId);
	public void updatePatient(Id patientId, Patient updatedPatient);
	public void save(Patient patient);
	public void delete(Id patientId);
	public Optional<Patient> findById(Id patientId);
}
