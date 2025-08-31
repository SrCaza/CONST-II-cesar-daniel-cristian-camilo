package app.domain.port.in.appointment;

import app.domain.model.Appointment;

public interface ScheduleAppointmentUseCase {
    void schedule(Appointment appointment);
}
