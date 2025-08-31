package app.domain.services;

import java.util.List;

import app.domain.model.Patient;
import app.domain.port.out.DoctorRepository;
import app.domain.port.out.MedicalRecordRepository;

public class DoctorService {
	private final DoctorRepository doctorRepository;

	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public List<Patient>findAllPatient(DoctorService findPatients){
		return (List<Patient>) findPatients;
	}
	public List<Patient>searchPatientById(DoctorService searchPatient){
		return (List<Patient>) searchPatient;
	}

	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord) {
		MedicalRecordRepository.save(modifyMedicalRecord);
	}
	public void deleteMedicalRecord(long id, DoctorService deleteMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = null;
	}

}
