package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.domain.valueobject.UserId;
@Service
public class UserManagementService {
	@Autowired
    private final UserRepository userRepository;

    public UserManagementService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


	public void create(User user) throws Exception {
		if (userRepository.findByUsername(user) != null) {
			throw new Exception("ya existe una persona registrada con esa cedula");
		}

		if (!user.getRole().equals(Role.OWNER) && userRepository.findByUsername(user) != null) {
			throw new Exception("ya existe una persona registrada con ese nombre de usuario");
		}
		userRepository.save(user);
	}
}
