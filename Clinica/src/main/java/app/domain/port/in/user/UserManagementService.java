package app.domain.port.in.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.valueobject.UserId;
@Service
public class UserManagementService {
	@Autowired
    private final UserRepository userRepository;

    public UserManagementService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws Exception{
    	if (user == null || user == user) {
    		throw new Exception("El campo no debe estar vacio");
    	}
        userRepository.save(user);
    }

    public void deleUser(UserId userId){
        userRepository.delete(userId);
    }
}
