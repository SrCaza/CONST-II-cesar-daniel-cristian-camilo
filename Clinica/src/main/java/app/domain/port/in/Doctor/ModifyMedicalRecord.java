package app.domain.port.in.Doctor;

import app.domain.port.out.MedicalRecordRepository;

public class ModifyMedicalRecord {
	private final DoctorRepository doctorRepository;

	public ModifyMedicalRecord(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	public void modifyMedicalRecord(long id, DoctorService modifyMedicalRecord) {
		MedicalRecordRepository.save(modifyMedicalRecord);
	}


}
