package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.port.in.patient.Patient;

public class SearchPatientById {
	
	private final NurseRepository nurseRepository;
	
	public SearchPatientById(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
		
	}
	public List<Patient> searchPatientByid(long id, SearchMedicalRecordByid searchPatientByid){
		return (List<Patient>) searchPatientByid;
	}

}
