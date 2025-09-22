package app.domain.repositories;

import java.util.List;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.port.in.Nurse.SearchMedicalRecordByid;

public interface NurseRepository {
	
	public void addMedicalRecord(SearchMedicalRecordByid addMedicalRecord);
	public List<Patient> searchPatientByid(long id, SearchMedicalRecordByid searchPatientByid);
	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid);
}
