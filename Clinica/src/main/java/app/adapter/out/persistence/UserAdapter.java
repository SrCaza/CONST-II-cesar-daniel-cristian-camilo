package app.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.domain.valueobject.Id;
import app.domain.valueobject.UserId;
import app.infrastructure.percistence.mapper.UserMapper;
import app.infrastructure.percistence.entities.UserEntity;

@Service
public class UserAdapter implements UserRepository {

	@Autowired
	private app.infrastructure.percistence.repositories.UserRepository jpaUserRepository;

	@Override
	public void save(User user) {
		UserEntity entity = UserMapper.toEntity(user);
		jpaUserRepository.save(entity);
		System.out.println("Usuario creado exitosamente: " + user.getName());
	}

	@Override
	public void delete(UserId id) {
		jpaUserRepository.deleteById(Long.parseLong(id.getValue()));
	}

	@Override
	public Optional<User> findById(UserId id) {
		Optional<UserEntity> entity = jpaUserRepository.findById(Long.parseLong(id.getValue()));
		return entity.map(UserMapper::toDomain);
	}

	@Override
	public void delete(Id id) {
		jpaUserRepository.deleteById(Long.parseLong(id.getValue()));
	}

	@Override
	public Optional<User> findByUsername(String username) {
		UserEntity entity = jpaUserRepository.findByUserName(username);
		if (entity == null) {
			return Optional.empty();
		}
		return Optional.of(UserMapper.toDomain(entity));
	}

	@Override
	public List<User> findAll() {
		return jpaUserRepository.findAll().stream()
			.map(UserMapper::toDomain)
			.toList();
	}

	@Override
	public User findByUsername(User user) {
		UserEntity entity = jpaUserRepository.findByUserName(user.getUsername());
		if (entity == null) {
			return null;
		}
		return UserMapper.toDomain(entity);
	}
}
