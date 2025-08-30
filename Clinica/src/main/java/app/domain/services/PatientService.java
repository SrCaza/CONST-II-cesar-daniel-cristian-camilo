package app.domain.services;

import java.util.List;

import app.domain.model.Patient;
import app.domain.ports.out.PatientRepository;

public class PatientService {
	
	private final PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	public List<Patient> FindPatientById(long id, Patient FindPatient) {
		return (List<Patient>) FindPatient;
	}
	
	public void createPatient(Patient patient) {
		//validacion para saber si ya se encuentra algun ID osociado a otro paciente
		PatientRepository.save(patient);
	}
	
	public List <Patient> SerchPatient(long id, Patient serchPatient) {
		//validacion o mensaje en caso de que no se encuentre al paciente
		return (List<Patient>) serchPatient;
	}
	
	public void UpdatePatient(long id, Patient updatePatient) {
		Patient patient = updatePatient;
		PatientRepository.save(patient);
	}
	
	public void DeletePatient(long id, Patient Deletepatient ) {
		Patient patient = null;
		PatientRepository.save(null);
		//validacion para el ID
	}

}
