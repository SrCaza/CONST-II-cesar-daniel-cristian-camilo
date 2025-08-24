package app.domain.ports.out;

import app.domain.model.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    void save(Patient patient);
    Optional<Patient> findById(long id);
    List<Patient> findAll();
    void delete(long id);
}
