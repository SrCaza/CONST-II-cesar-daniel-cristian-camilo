package app.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;

@Service
public class UserManagementService {
	
	@Autowired
    private UserRepository userRepository;

    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) throws Exception {
        // Verificar si existe usuario con el mismo documento
        Optional<User> existingByUsername = userRepository.findByUsername(user.getUsername());
        
        if (existingByUsername.isPresent()) {
            throw new Exception("Ya existe una persona registrada con ese nombre de usuario");
        }

        // Guardar usuario
        userRepository.save(user);
        System.out.println("Usuario creado: " + user.getName() + " con rol: " + user.getRole());
    }
}
