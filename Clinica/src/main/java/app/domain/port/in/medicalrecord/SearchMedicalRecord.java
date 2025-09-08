package app.domain.port.in.medicalrecord;

import java.util.List;

public class SearchMedicalRecord {
	private final MedicalRecordRepository medicalRecordRepository;
	
	public  SearchMedicalRecord(MedicalRecordRepository medicalRecordRepository) {
		this.medicalRecordRepository = medicalRecordRepository;
	}
	public List<MedicalRecord> SearchMedicalRecord(long id, MedicalRecord searchMedicalRecord) {
		return (List<MedicalRecord>) searchMedicalRecord;
	}

}
