package app.domain.port.out;

import java.util.List;


import app.domain.port.in.Doctor.Doctor;
import app.domain.port.in.Doctor.DoctorService;
import app.domain.port.in.Nurse.SearchMedicalRecordByid;
import app.domain.port.in.medicalrecord.MedicalRecord;

public interface MedicalRecordRepository {
	public void CreateMedicalRecord(MedicalRecord createMedicalRecord);
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord);
	public static void save(MedicalRecord medicalRecord, Doctor doctor) {} 
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord);
	public static void save(DoctorService modifyMedicalRecord) {}
	public static void save(SearchMedicalRecordByid addMedicalRecord) {}
}
