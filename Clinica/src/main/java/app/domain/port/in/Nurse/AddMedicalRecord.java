package app.domain.port.in.Nurse;

import app.domain.repositories.MedicalRecordRepository;
import app.domain.repositories.NurseRepository;

public class AddMedicalRecord {
	private final NurseRepository nurseRepository;
	
	public AddMedicalRecord(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}
	public void addMedicalRecord(AddMedicalRecord addMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = (MedicalRecordRepository) addMedicalRecord;
	}
}
