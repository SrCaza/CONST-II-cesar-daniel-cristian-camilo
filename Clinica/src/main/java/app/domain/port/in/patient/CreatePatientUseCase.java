package app.domain.port.in.patient;

import app.domain.model.Patient;

public interface CreatePatientUseCase {
    void createPatient(Patient patient);
}

