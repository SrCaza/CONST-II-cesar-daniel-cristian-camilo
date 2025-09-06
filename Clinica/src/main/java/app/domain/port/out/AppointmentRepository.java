package app.domain.port.out;

import app.domain.port.in.appointment.Appointment;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface AppointmentRepository {
    void save(Appointment appointment);
    void delete(Id id);
    Optional<Appointment> findById(Id id);
    List<Appointment> findByPatientId(Id patientId);
}
