package app.domain.port.in.patient;

import app.domain.valueobject.Id;

public interface DeletePatientUseCase {
    void deletePatient(Id patientId);
}
