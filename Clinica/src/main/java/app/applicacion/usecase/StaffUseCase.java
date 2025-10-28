package app.applicacion.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Staff;
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.StaffRepository;
import app.domain.services.UserManagementService;

@Service
public class StaffUseCase {
	
	@Autowired
	private UserManagementService userManagementService;
	
	public User CreateDoctor(User user) throws Exception {
		user.setRole(Role.DOCTOR);
		userManagementService.create(user);
		return user;
	}
	
	public User createNurse(User user) throws Exception {
		user.setRole(Role.NURSE);
		userManagementService.create(user);
		return user;
	}

}
