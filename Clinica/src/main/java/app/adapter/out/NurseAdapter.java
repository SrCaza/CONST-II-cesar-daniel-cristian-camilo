package app.adapter.out;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.port.in.Nurse.NurseRepository;
import app.domain.port.in.Nurse.SearchMedicalRecordByid;
import app.domain.port.in.medicalrecord.MedicalRecord;
import app.domain.port.in.patient.Patient;

@Service
public class NurseAdapter implements NurseRepository {

	@Override
	public void addMedicalRecord(SearchMedicalRecordByid addMedicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> searchPatientByid(long id, SearchMedicalRecordByid searchPatientByid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalRecord> searchMedicalRecordByid(long id, SearchMedicalRecordByid searchMedicalRecordByid) {
		// TODO Auto-generated method stub
		return null;
	}

}
