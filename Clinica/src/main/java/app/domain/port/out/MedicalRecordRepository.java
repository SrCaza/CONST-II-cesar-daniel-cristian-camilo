package app.domain.port.out;

import java.util.List;

import app.domain.model.Doctor;
import app.domain.model.MedicalRecord;
import app.domain.services.DoctorService;
import app.domain.services.NurseService;

public interface MedicalRecordRepository {
	public void CreateMedicalRecord(MedicalRecord createMedicalRecord);
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord);
	public static void save(MedicalRecord medicalRecord, Doctor doctor) {} 
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord);
	public static void save(DoctorService modifyMedicalRecord) {}
	public static void save(NurseService addMedicalRecord) {}
}
