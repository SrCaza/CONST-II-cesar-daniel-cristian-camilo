package app.infrastructure.percistence.mapper;

import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.infrastructure.percistence.entities.UserEntity;


public class UserMapper {
    public static UserEntity toEntity(User user) {
        if (user == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setDocument(user.getDocument());
        entity.setAge(user.getAge());
    entity.setRole(user.getRole() != null ? String.valueOf(user.getRole()) : null);
        entity.setUserName(user.getUsername());
        entity.setPassword(user.getPassword());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setDocument(entity.getDocument());
        user.setAge(entity.getAge());
        user.setRole(parseRole(entity.getRole()));
        user.setUsername(entity.getUserName());
        user.setPassword(entity.getPassword());
        return user;
    }

    private static Role parseRole(String role) {
        if (role == null) return null;
        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

}
