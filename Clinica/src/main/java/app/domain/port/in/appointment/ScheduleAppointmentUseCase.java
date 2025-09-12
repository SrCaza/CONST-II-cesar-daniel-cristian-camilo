package app.domain.port.in.appointment;

public class ScheduleAppointmentUseCase {
	
	 private final AppointmentRepository appointmentRepository;
	public ScheduleAppointmentUseCase(AppointmentRepository appointmentRepository) {
	        this.appointmentRepository = appointmentRepository;
	 }
    public void schedule(Appointment appointment) {
    	
    }
}
