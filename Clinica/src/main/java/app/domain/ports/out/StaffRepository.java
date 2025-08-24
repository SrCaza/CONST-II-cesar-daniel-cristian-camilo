package app.domain.ports.out;

import app.domain.model.Staff;
import java.util.List;
import java.util.Optional;

public interface StaffRepository {
    void save(Staff staff);
    Optional<Staff> findById(long id);
    List<Staff> findAll();
    void delete(long id);
    void updateStaffData(Staff staff);
}
