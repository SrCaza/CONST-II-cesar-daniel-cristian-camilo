package app.domain.port.in.appointment;

import app.domain.valueobject.Id;

public interface CancelAppointmentUseCase {
    void cancel(Id appointmentId);
}
