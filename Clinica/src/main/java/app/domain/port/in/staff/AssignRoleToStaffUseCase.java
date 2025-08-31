package app.domain.port.in.staff;

import app.domain.model.Role;

public interface AssignRoleToStaffUseCase {
    void assignRoleToStaff(Long staffId, Role role);
}
