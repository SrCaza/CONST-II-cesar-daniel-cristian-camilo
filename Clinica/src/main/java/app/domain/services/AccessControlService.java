package app.domain.services;

import app.domain.model.User;
import app.domain.ports.out.UserRepository;
import app.domain.valueobject.UserId;
import app.domain.model.Role;

import java.util.Optional;

public class AccessControlService {
    private final UserRepository userRepository;

    public AccessControlService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void changeUserRole(UserId userId, Role newRole){
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()){
            User user = userOpt.get();
            user.changeRole(newRole);
            userRepository.save(user);
        }else {
            throw new IllegalArgumentException("Usuario no encontrado con el némero de cédula "+ userId.getValue());
        }
    }

}
