package app.applicacion.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repositories.DoctorRepository;
import app.domain.repositories.MedicalRecordRepository;
import app.domain.repositories.PatientRepository;
import app.domain.services.DoctorService;
import app.domain.valueobject.Id;

@Service
public class DoctorUseCase {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public void deletePatient(Id deletePatient) {
		PatientRepository patientRepository = null;
	}
	public List<Patient>findAllPatient(DoctorService findPatients){
		return (List<Patient>) findPatients;
	}
	public void modifyMedicalRecord(Id modifyMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = (MedicalRecordRepository) modifyMedicalRecord;
	}
	public List<MedicalRecord>searchMedicalRecord(Id searchMedicalRecord){
		return (List<MedicalRecord>) searchMedicalRecord;
	}
	public List<Patient>searchPatientById(DoctorService searchPatient){
		return (List<Patient>) searchPatient;
	}

}
