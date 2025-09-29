package app.applicacion.usecase;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.Appointment;
import app.domain.repositories.AppointmentRepository;
import app.domain.valueobject.Id;

@Service
public class AppoinmentUseCase {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public void createAppointment(Id newAppointment) {
		
	}

	public void cancelApoinment(Id appointmentId) {
		appointmentRepository = null;
	}

	public void deleteAppointment(Id appointmentId) {
		appointmentRepository.delete(appointmentId);
	}

	public List<Appointment> getAppointmentsByPatient(Id patientId) {
		return appointmentRepository.findByPatientId(patientId);
	}

	public void reschedule(Id appointmentId, Appointment updatedAppointment) {
		appointmentRepository.save(updatedAppointment);

	}

	public void schedule(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

}
