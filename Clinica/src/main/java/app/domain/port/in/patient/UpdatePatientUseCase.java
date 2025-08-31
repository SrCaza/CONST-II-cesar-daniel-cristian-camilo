package app.domain.port.in.patient;

import app.domain.model.Patient;
import app.domain.valueobject.Id;

public interface UpdatePatientUseCase {
    void updatePatient(Id patientId, Patient updatedPatient);
}

