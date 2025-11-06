package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repositories.NurseRepository;
import app.domain.valueobject.Id;

@Service
public class NurseUseCase {
	
	@Autowired
	private NurseRepository nurseRepository;
	
	public void addMedicalRecord(Id addMedicalRecord) {
		Id medicalRecordRepository = addMedicalRecord;
	}
	public List<MedicalRecord> searchMedicalRecordByid(Id searchMedicalRecordByid){
		return (List<MedicalRecord>) searchMedicalRecordByid;
	}
	public List<Patient> searchPatientByid(Id searchPatientByid){
		return (List<Patient>) searchPatientByid;
	}
	

}
