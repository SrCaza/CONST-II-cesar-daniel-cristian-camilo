package app.domain.port.in.medicalrecord;

import java.util.List;

import app.domain.port.out.MedicalRecordRepository;

public class MedicalRecordService {
	
	private MedicalRecordRepository medicalRecordRepository;
	
	public void MecicalRecordService(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	
	public void CreateMedicalRecord(MedicalRecord medicalRecord) {
		MedicalRecordRepository.save(medicalRecord, null);
	}
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
		return (List<MedicalRecord>) searchMedicalRecord;
	}
	
	public void UpdateMedicalRecord(long id, MedicalRecord updateMedicalRecord) {
		MedicalRecord medicalRecord =  updateMedicalRecord;
		MedicalRecordRepository.save(medicalRecord, null);
	}
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord) {
		MedicalRecord medicalRecord = null;
	}

}

