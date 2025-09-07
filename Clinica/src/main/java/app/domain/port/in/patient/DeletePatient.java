package app.domain.port.in.patient;

import app.domain.valueobject.Id;

public interface DeletePatient {
    public void deletePatient(Id patientId);
}
