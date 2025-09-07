package app.adapter.out;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.port.in.Doctor.DoctorRepository;
import app.domain.port.in.Doctor.DoctorService;
import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;
import app.domain.valueobject.Id;

@Service
public class DoctorAdapter implements DoctorRepository{

	@Override
	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedicalRecord(long id, DoctorService deleteMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> findAllPatient(DoctorService findPatients) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> searchPatientById(DoctorService searchPatient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalRecord> searchMedicalRecord(Id searchMedicalRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatient(Id deletePatient) {
		// TODO Auto-generated method stub
		
	}

}
