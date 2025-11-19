package app.application.usecases;
 
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.services.UserManagementService;
import app.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class PatientUseCase {
 
    @Autowired
    private UserManagementService userManagementService;
 
    @Autowired
    private UserRepository userRepository;
 
    public void createPatient(User user) throws Exception {
        user.setRole(Role.PATIENT);
        userManagementService.create(user);
    }
 
    public List<User> findAllPatients() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .filter(u -> u.getRole() == Role.PATIENT)
                .collect(Collectors.toList());
    }
 
    public void updatePatient(long id, User updatedPatient) throws Exception {
        updatedPatient.setRole(Role.PATIENT);
        userManagementService.update(id, updatedPatient);
    }
 
    public void deletePatient(long id) throws Exception {
        userManagementService.delete(id);
    }
}