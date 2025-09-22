package app.domain.port.in.patient;

import app.domain.repositories.AppointmentRepository;
import app.domain.repositories.PatientRepository;
import app.domain.valueobject.Id;

public class DeletePatient {
	
	   private final PatientRepository patientRepository;

	public DeletePatient(PatientRepository patientRepository) {
	        this.patientRepository = patientRepository;
	    }
	
    public void deletePatient(Id patientId) {
    	
    }
}
