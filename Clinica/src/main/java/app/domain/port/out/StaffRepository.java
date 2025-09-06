package app.domain.port.out;

import java.util.List;
import java.util.Optional;

import app.domain.port.in.staff.Staff;

public interface StaffRepository {
    void save(Staff staff);
    Optional<Staff> findById(long id);
    List<Staff> findAll();
    void delete(long id);
    void updateStaffData(Staff staff);
}
