package app.domain.port.in.Nurse;

import app.domain.port.in.medicalrecord.MedicalRecordRepository;

public class AddMedicalRecord {
	private final NurseRepository nurseRepository;
	
	public AddMedicalRecord(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}
	public void addMedicalRecord(SearchMedicalRecordByid addMedicalRecord) {
		MedicalRecordRepository.save(addMedicalRecord);
	}
}
