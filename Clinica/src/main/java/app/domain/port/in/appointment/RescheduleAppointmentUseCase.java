package app.domain.port.in.appointment;

import app.domain.model.Appointment;
import app.domain.valueobject.Id;

public interface RescheduleAppointmentUseCase {
    void reschedule(Id appointmentId, Appointment updatedAppointment);
}
