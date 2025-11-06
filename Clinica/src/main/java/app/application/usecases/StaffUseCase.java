package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.services.UserManagementService;

@Service
public class StaffUseCase {
	
	@Autowired
	private UserManagementService userManagementService;
	
	public User createDoctor(User user) throws Exception {
		user.setRole(Role.DOCTOR);
		userManagementService.create(user);
		return user;
	}
	
	public User createNurse(User user) throws Exception {
		user.setRole(Role.NURSE);
		userManagementService.create(user);
		return user;
	}

    public User createStaff(User user) throws Exception {
        user.setRole(Role.ADMINISTRATIVE_STAFF);
        userManagementService.create(user);
        return user;
    }

    public User createHumanResources(User user) throws Exception{
        user.setRole(Role.HUMAN_RESOURCES);
        userManagementService.create(user);
        return user;
    }

    public User createPatient(User user) throws Exception{
        user.setRole(Role.PATIENT);
        userManagementService.create(user);
        return user;
    }

}
