package app.application.usecases;
 
import java.util.List;
 
import app.domain.model.Enum.Role;
import app.domain.model.User;
import app.domain.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import app.domain.model.HumanResources;
import app.domain.repositories.HumanResourcesRepository;
import app.domain.valueobject.Id;
 
 
 
@Service
public class HumanResourcesUseCase {
 
    @Autowired
    private UserManagementService userManagementService;
 
    public void createDoctor(User user) throws Exception {
        user.setRole(Role.DOCTOR);
        userManagementService.create(user);
    }
 
    public void createNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        userManagementService.create(user);
    }
 
    public void createStaff(User user) throws Exception {
        user.setRole(Role.ADMINISTRATIVE_STAFF);
        userManagementService.create(user);
    }
 
    public void createHumanResources(User user) throws Exception{
        user.setRole(Role.HUMAN_RESOURCES);
        userManagementService.create(user);
    }
 
    public void createPatient(User user) throws Exception{
        user.setRole(Role.PATIENT);
        userManagementService.create(user);
    }
 
    //no esta es funcionamiento en ninguna implementacion
	public void createEmployee(HumanResourcesRepository createEmployee) {
		HumanResourcesRepository.save(createEmployee);
	}
 
	public void deleteEmployee(Id deleteEmployee) {
		
	}
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee){
		return (List<HumanResources>) updateEmployee;
	}
 
    // New: update existing doctor
    public void updateDoctor(long id, User updatedDoctor) throws Exception {
        // ensure role stays DOCTOR
        updatedDoctor.setRole(Role.DOCTOR);
        userManagementService.update(id, updatedDoctor);
    }
 
}
