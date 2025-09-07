package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;

public interface NurseRepository {
	
	public void addMedicalRecord(SearchMedicalRecordByid addMedicalRecord);
	public List<Patient> searchPatientByid(long id, SearchMedicalRecordByid searchPatientByid);
	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid);
}
