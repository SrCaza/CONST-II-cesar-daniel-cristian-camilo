package app.domain.port.in.medicalrecord;

import java.util.List;


import app.domain.port.in.Doctor.Doctor;
import app.domain.port.in.Doctor.DoctorService;
import app.domain.port.in.Nurse.SearchMedicalRecordByid;
import app.domain.valueobject.Id;

public interface MedicalRecordRepository {
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord);
	public void save(MedicalRecord medicalRecord, Doctor doctor);
	public void DeleteMedicalRecord(long id, MedicalRecord DeleteMedicalRecord);
	public void save(DoctorService modifyMedicalRecord);
	public void save(SearchMedicalRecordByid addMedicalRecord);
	public void save(Id createmedicalRecord);
}
