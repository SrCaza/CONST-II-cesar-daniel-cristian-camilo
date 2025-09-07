package app.domain.port.in.Doctor;

import java.util.List;

import app.domain.port.in.patient.Patient;

public class SearchPatientById {
	private final DoctorRepository doctorRepository;

	public SearchPatientById(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	public List<Patient>searchPatientById(DoctorService searchPatient){
		return (List<Patient>) searchPatient;
	}

}
