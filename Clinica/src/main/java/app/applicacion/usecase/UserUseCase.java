package app.applicacion.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.domain.valueobject.UserId;

@Service
public class UserUseCase {

	@Autowired
	private UserRepository userRepository;

	void create(User user) throws Exception{

	}



	void changeRole(UserId userId, Role role) {

	}

}
