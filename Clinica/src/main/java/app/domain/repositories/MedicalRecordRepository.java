package app.domain.repositories;

import java.util.List;


import app.domain.model.Doctor;
import app.domain.model.MedicalRecord;
import app.domain.services.DoctorService;
import app.domain.valueobject.Id;

public interface MedicalRecordRepository {
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord);
	public void save(MedicalRecord medicalRecord, Doctor doctor);
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord);
	public void save(DoctorService modifyMedicalRecord);
	public <SearchMedicalRecordByid> void save(SearchMedicalRecordByid addMedicalRecord);
	public void save(Id createmedicalRecord);
	
}
