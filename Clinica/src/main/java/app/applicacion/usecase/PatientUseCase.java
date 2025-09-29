package app.applicacion.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.repositories.PatientRepository;
import app.domain.valueobject.Id;

@Service
public class PatientUseCase {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public void createPatient(Patient patient) {
		
	}
    public void deletePatient(Id patientId) {
    	
    }
    public List<Patient> updatePatient(Id patientId, Patient updatedPatient) {
		return null;
	}
    public List<Patient>findPatientById(Id patientId) {
    return (List<Patient>) patientId;
    }

}
