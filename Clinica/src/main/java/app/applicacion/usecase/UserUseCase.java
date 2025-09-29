package app.applicacion.usecase;

import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.domain.valueobject.UserId;

public class UserUseCase {

	private UserRepository userRepository;

	void create(User user) {

	}

	void changeRole(UserId userId, Role role) {

	}

}
