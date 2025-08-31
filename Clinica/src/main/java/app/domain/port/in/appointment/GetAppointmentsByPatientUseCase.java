package app.domain.port.in.appointment;

import app.domain.model.Appointment;
import app.domain.valueobject.Id;
import java.util.List;

public interface GetAppointmentsByPatientUseCase {
    List<Appointment> getAppointmentsByPatient(Id patientId);
}
