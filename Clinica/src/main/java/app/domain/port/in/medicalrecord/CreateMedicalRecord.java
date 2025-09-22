package app.domain.port.in.medicalrecord;

import app.domain.repositories.MedicalRecordRepository;
import app.domain.valueobject.Id;

public class CreateMedicalRecord {
	
	private final MedicalRecordRepository medicalRecordRepository;

	public CreateMedicalRecord(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	public void CreateMedicalRecord (Id createmedicalRecord) {
		medicalRecordRepository.save(createmedicalRecord);
	}
}
