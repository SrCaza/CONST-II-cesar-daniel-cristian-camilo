package app.domain.services;

import java.util.List;

import app.domain.model.Patient;
import app.domain.repositories.DoctorRepository;
import app.domain.repositories.MedicalRecordRepository;
import app.domain.valueobject.Id;

public class DoctorService {
	private final DoctorRepository doctorRepository;

	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public void deleteMedicalRecord(Id deleteMedicalRecord) {
		MedicalRecordRepository medicalRecordRepository = null;
	}

}
