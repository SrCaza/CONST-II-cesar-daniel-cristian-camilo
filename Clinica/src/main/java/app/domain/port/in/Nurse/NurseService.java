package app.domain.port.in.Nurse;

import java.util.List;

import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;
import app.domain.port.out.MedicalRecordRepository;

public class NurseService {
	private NurseRepository nurseRepository;
	
	public NurseService(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}
	public void addMedicalRecord(NurseService addMedicalRecord) {
		MedicalRecordRepository.save(addMedicalRecord);
	}
	public List<Patient> searchPatientByid(long id, NurseService searchPatientByid){
		return (List<Patient>) searchPatientByid;
	}
	public List<MedicalRecord> searchMedicalRecordByid(long id, NurseService searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	

}
