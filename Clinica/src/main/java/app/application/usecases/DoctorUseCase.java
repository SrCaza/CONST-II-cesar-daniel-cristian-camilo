package app.application.usecases;
 
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;
import app.domain.repositories.DoctorRepository;
import app.domain.repositories.MedicalRecordRepository;
import app.domain.repositories.PatientRepository;
import app.domain.services.DoctorService;
import app.domain.valueobject.Id;
import app.domain.repositories.UserRepository;
import app.domain.model.User;
import app.domain.model.Enum.Role;
 
@Service
public class DoctorUseCase {
	
	@Autowired
	private DoctorRepository doctorRepository;
 
	@Autowired
	private UserRepository userRepository;
	
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
 
	public List<User> findAllDoctors() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .filter(u -> u.getRole() == Role.DOCTOR)
                .collect(Collectors.toList());
    }
 
}
