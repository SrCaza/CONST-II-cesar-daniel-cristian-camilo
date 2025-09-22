package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repositories.MedicalRecordRepository;
import app.domain.repositories.NurseRepository;

public class SearchMedicalRecordByid {
	private final NurseRepository nurseRepository;
	
	public SearchMedicalRecordByid(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}

	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	

}
