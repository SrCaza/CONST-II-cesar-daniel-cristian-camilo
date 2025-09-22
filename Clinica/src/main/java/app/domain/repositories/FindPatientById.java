package app.domain.repositories;

import app.domain.model.Patient;
import app.domain.valueobject.Id;

import java.util.List;

public class FindPatientById {
    public List<Patient>findPatientById(Id patientId) {
    return (List<Patient>) patientId;
    }
}
