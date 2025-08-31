package app.domain.ports.out;

import app.domain.model.Patient;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface PatientRepository {
    void save(Patient patient);
    void delete(Id id);
    Optional<Patient> findById(Id id);
    List<Patient> findAll();
}
