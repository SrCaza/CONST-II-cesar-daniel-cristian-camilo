package app.domain.services;

import app.domain.model.User;
import app.domain.valueobject.UserId;
import app.domain.port.out.UserRepository;

public class UserManagementService {
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
