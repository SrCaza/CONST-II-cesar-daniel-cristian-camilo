package app.domain.port.in.user;

import app.domain.model.User;

public interface CreateUserUseCase {
    void create(User user);
}
