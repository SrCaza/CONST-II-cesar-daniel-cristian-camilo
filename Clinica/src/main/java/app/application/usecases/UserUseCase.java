package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.application.exceptions.BusunessException;
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;

@Service
public class UserUseCase {

	@Autowired
	private UserRepository userRepository;

	// ==================== CREAR ====================
	
	public void create(User user) throws Exception {
		Optional<User> existingByUsername = userRepository.findByUsername(user.getUsername());
		
		if (existingByUsername.isPresent()) {
			throw new BusunessException("Ya existe un usuario con ese nombre de usuario");
		}

		userRepository.save(user);
	}

	// ==================== BUSCAR ====================
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(long id) {
		return userRepository.findById(new UserId(String.valueOf(id)));
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Optional<User> findByDocument(long document) {
		List<User> allUsers = userRepository.findAll();
		return allUsers.stream()
			.filter(user -> user.getDocument() == document)
			.findFirst();
	}

	// ==================== ACTUALIZAR ====================
	
	public void update(User user) throws Exception {
		Optional<User> existing = userRepository.findById(new UserId(String.valueOf(user.getId())));
		
		if (existing.isEmpty()) {
			throw new BusunessException("Usuario no encontrado");
		}

		// Verificar si el username cambió y si ya existe
		if (!existing.get().getUsername().equals(user.getUsername())) {
			Optional<User> existingByUsername = userRepository.findByUsername(user.getUsername());
			if (existingByUsername.isPresent() && existingByUsername.get().getId() != user.getId()) {
				throw new BusunessException("Ya existe un usuario con ese nombre de usuario");
			}
		}

		userRepository.save(user);
	}

	// ==================== ELIMINAR ====================
	
	public void delete(long id) throws Exception {
		Optional<User> existing = userRepository.findById(new UserId(String.valueOf(id)));
		
		if (existing.isEmpty()) {
			throw new BusunessException("Usuario no encontrado");
		}

		userRepository.delete(new UserId(String.valueOf(id)));
	}

	// ==================== CAMBIAR ROL ====================
	
	public void changeRole(long userId, Role role) throws Exception {
		Optional<User> userOpt = userRepository.findById(new UserId(String.valueOf(userId)));
		
		if (userOpt.isEmpty()) {
			throw new BusunessException("Usuario no encontrado");
		}

		User user = userOpt.get();
		user.setRole(role);
		userRepository.save(user);
	}
}
