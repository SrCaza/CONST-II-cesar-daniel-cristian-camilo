package app.applicacion.usecase;

import java.util.List;

import app.domain.model.Patient;
import app.domain.repositories.PatientRepository;
import app.domain.valueobject.Id;

public class PatientUseCase {
	
	private PatientRepository patientRepository;
	
	public void createPatient(Patient patient) {
		
	}
    public void deletePatient(Id patientId) {
    	
    }
    public List<Patient> updatePatient(Id patientId, Patient updatedPatient) {
		return null;
	}

}
