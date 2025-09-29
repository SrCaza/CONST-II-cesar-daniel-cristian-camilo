package app.applicacion.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.repositories.MedicalRecordRepository;
import app.domain.valueobject.Id;

@Service
public class MedicalRecordUseCase {
	
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	public void CreateMedicalRecord (Id createmedicalRecord) {
		medicalRecordRepository.save(createmedicalRecord);
	}
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord) {
		MedicalRecord medicalRecord = null;
	}
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
		return (List<MedicalRecord>) searchMedicalRecord;
	}
	public void UpdateMedicalRecord(long id, MedicalRecord updateMedicalRecord) {
		MedicalRecord medicalRecord =  updateMedicalRecord;
		medicalRecordRepository.save(medicalRecord, null);
	}

}
