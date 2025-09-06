package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;

public interface NurseRepository {
	
	public void addMedicalRecord(NurseService addMedicalRecord);
	public List<Patient> searchPatientByid(long id, NurseService searchPatientByid);
	public List<MedicalRecord> searchMedicalRecordByid(long id, NurseService searchMedicalRecordByid);
}
