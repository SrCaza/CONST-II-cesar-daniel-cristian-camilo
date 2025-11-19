package app.application.usecases;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import app.domain.model.MedicalRecord;
import app.domain.repositories.MedicalRecordRepository;
import app.domain.valueobject.Id;
import app.application.exceptions.EntityNotFoundException;
 
@Service
public class MedicalRecordUseCase {
	
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	public void CreateMedicalRecord (Id createmedicalRecord, MedicalRecord medicalRecord) {
		// delegate to repository save; repository API is inconsistent, use save(id) or save(medicalRecord, doctor)
		medicalRecordRepository.save(createmedicalRecord);
	}
	
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
		// SearchMedicalRecord seems to take patient id and return records
		return medicalRecordRepository.SearchMedicalRecord(id, searchMedicalRecord);
	}
	
	public void UpdateMedicalRecord(long id, MedicalRecord updateMedicalRecord) {
		// delegate update; repository.save(medicalRecord, doctor) exists
		medicalRecordRepository.save(updateMedicalRecord, null);
	}
 
	public void DeleteMedicalRecord(long id, MedicalRecord deleteMedicalRecord) {
		// delegate delete
		medicalRecordRepository.DeleteMedicalRecord(id, deleteMedicalRecord);
	}
 
}