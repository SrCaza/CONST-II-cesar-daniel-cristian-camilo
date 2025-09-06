package app.domain.services;

import app.domain.model.Role;
import app.domain.port.in.staff.Staff;
import app.domain.port.out.StaffRepository;
import java.util.Optional;

public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    public void createUser(Staff staff){
        staffRepository.save(staff);
    }

    public void deleteUser(long id){
        staffRepository.delete(id);
    }

    public void assignRoleToUser(long id, Role role){
        Optional<Staff> staffOptional = staffRepository.findById(id);
        if (staffOptional.isPresent()){
            Staff staff = staffOptional.get();
            staff.setRole(role);
            staffRepository.save(staff);
            staffRepository.save(staff);
        }
    }

    public void updateUserPermissions(long id, String newPermissions){
        Optional<Staff> staffOptional = staffRepository.findById(id);
        if (staffOptional.isPresent()){
            Staff staff = staffOptional.get();
            staff.setPermissions(newPermissions);
            staffRepository.save(staff);
        }
    }

    public void updateStaffData(Staff staff){
        staffRepository.updateStaffData(staff);
    }
}
