package app.domain.port.in.patient;

import app.domain.model.Patient;
import app.domain.valueobject.Id;
import java.util.Optional;

public interface FindPatientByIdUseCase {
    Optional<Patient> findPatientById(Id patientId);
}
