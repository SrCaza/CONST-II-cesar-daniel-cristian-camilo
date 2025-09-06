package app.domain.port.in.medicalrecord;

import java.util.Optional;

public interface GetMedicalRecordUseCase {
    Optional<MedicalRecord> getMedicalRecordById(Long id);
}

