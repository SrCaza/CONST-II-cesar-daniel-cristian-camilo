package app.domain.services;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.infrastructure.percistence.entities.UserEntity;
import java.util.Optional;
import app.domain.valueobject.UserId;
import app.application.exceptions.EntityNotFoundException;
@Service
public class UserManagementService {
	@Autowired
    private final UserRepository userRepository;
 
    @Autowired
    private app.infrastructure.percistence.repositories.UserRepository jpaUserRepository;
 
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
 
	public void update(long id, User updated) {
		// find existing entity via JPA repository
		Optional<UserEntity> opt = jpaUserRepository.findById(id);
		if (!opt.isPresent()) {
			throw new EntityNotFoundException("Usuario no encontrado con id: " + id);
		}
		UserEntity entity = opt.get();
		// update mutable fields
		if (updated.getName() != null) entity.setName(updated.getName());
		if (updated.getPassword() != null) entity.setPassword(updated.getPassword());
		if (updated.getAge() != 0) entity.setAge(updated.getAge());
		if (updated.getUsername() != null) entity.setUserName(updated.getUsername());
		// role: keep as provided (use case ensures correct role)
		if (updated.getRole() != null) entity.setRole(String.valueOf(updated.getRole()));
		if (updated.getDocument() != 0) entity.setDocument(updated.getDocument());
		// persist
		jpaUserRepository.save(entity);
	}
 
	public void delete(long id) {
		if (!jpaUserRepository.existsById(id)) {
			throw new EntityNotFoundException("Usuario no encontrado con id: " + id);
		}
		jpaUserRepository.deleteById(id);
	}
}