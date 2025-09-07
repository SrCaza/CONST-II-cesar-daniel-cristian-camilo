package app.domain.port.in.Doctor;

import java.util.List;

import app.domain.port.in.patient.Patient;
import app.domain.port.out.MedicalRecordRepository;
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
