package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;
import app.domain.port.out.MedicalRecordRepository;

public class SearchMedicalRecordByid {
	private final NurseRepository nurseRepository;
	
	public SearchMedicalRecordByid(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}

	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	

}
