package app.domain.port.in.patient;

import app.domain.valueobject.Id;

import java.util.List;

public class FindPatientById {
    public List<Patient>findPatientById(Id patientId) {
    return (List<Patient>) patientId;
    }
}
