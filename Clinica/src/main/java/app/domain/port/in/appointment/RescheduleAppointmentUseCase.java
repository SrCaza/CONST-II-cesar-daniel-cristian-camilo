package app.domain.port.in.appointment;

import app.domain.valueobject.Id;

public class RescheduleAppointmentUseCase {
	
	 private final AppointmentRepository appointmentRepository;
	public RescheduleAppointmentUseCase(AppointmentRepository appointmentRepository) {
	        this.appointmentRepository = appointmentRepository;
	 }
    public void reschedule(Id appointmentId, Appointment updatedAppointment) {
    	System.out.println("Nueva cita registrada");
    	
    }
}
