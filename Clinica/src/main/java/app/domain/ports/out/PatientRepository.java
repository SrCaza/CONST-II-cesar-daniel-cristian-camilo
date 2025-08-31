package app.domain.ports.out;

import app.domain.model.Patient;
import app.domain.services.DoctorService;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface PatientRepository {
    public void save(Patient patient);
    void delete(Id id);
    Optional<Patient> findById(Id id);
    List<Patient> findAll();
	public static void save(DoctorService createpatient) {}

}
