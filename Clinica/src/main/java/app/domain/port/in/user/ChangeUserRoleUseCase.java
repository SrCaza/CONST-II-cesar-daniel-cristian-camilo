package app.domain.port.in.user;

import app.domain.model.Enum.Role;
import app.domain.valueobject.UserId;

public interface ChangeUserRoleUseCase {
    void changeRole(UserId userId, Role role);
}
