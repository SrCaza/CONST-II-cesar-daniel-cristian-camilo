package app.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.repositories.DoctorRepository;
import app.domain.repositories.PatientRepository;
import app.domain.services.DoctorService;
import app.domain.valueobject.Id;

@Service
public class PatientAdapter implements  PatientRepository{

	@Override
	public void createPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient(Id patientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> findPatientById(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePatient(Id patientId, Patient updatedPatient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Id patientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Patient> findById(Id patientId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



}
