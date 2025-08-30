package app.domain.ports.out;

import app.domain.model.Patient;
import java.util.List;

public interface PatientRepository {
	public void createPatient(Patient patient);
	public void UpdatePatient(long id, Patient updatePatient);
	public void DeletePatient(long id, Patient Deletepatient );
	public List<Patient> FindPatientById(long id, Patient FindPatient);
    public List <Patient> SerchPatient(long id, Patient serchPatient);
	public static void save(Patient patient) {}
}
