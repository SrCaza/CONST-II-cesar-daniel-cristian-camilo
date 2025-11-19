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
public class NurseUseCase {
 
    @Autowired
    private UserManagementService userManagementService;
 
    @Autowired
    private UserRepository userRepository;
 
    public void createNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        userManagementService.create(user);
    }
 
    public List<User> findAllNurses() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .filter(u -> u.getRole() == Role.NURSE)
                .collect(Collectors.toList());
    }
 
    public void updateNurse(long id, User updatedNurse) throws Exception {
        updatedNurse.setRole(Role.NURSE);
        userManagementService.update(id, updatedNurse);
    }
 
    public void deleteNurse(long id) throws Exception {
        userManagementService.delete(id);
    }
}