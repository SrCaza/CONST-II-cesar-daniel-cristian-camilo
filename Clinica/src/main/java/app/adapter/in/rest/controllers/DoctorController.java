package app.adapter.in.rest.controllers;
 
import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.HumanResourcesUseCase;
import app.application.usecases.DoctorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import app.domain.model.User;
import app.domain.model.Enum.Role;
import app.domain.repositories.UserRepository;
import app.application.exceptions.EntityNotFoundException;
 
import java.util.List;
import java.util.stream.Collectors;
 
 
@RestController
@RequestMapping("/api/doctor")
@PreAuthorize("hasRole('HUMAN_RESOURCES') or hasRole('ADMINISTRATIVE_STAFF')")
public class DoctorController {
 
    @Autowired
    private UserRestMapper userRestMapper;
 
    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;
 
    @Autowired
    private DoctorUseCase doctorUseCase;
 
    @PostMapping("/users")
    public ResponseEntity<UserResponse> createDoctor(@RequestBody CreateUserRequest request) throws Exception {
        User doctor = userRestMapper.toDomain(request);
        humanResourcesUseCase.createDoctor(doctor);
        return new ResponseEntity<>(userRestMapper.toResponse(doctor), HttpStatus.CREATED);
    }
 
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> findAllDoctors() {
        List<User> doctorsList = doctorUseCase.findAllDoctors();
        List<UserResponse> doctors = doctorsList.stream()
                .map(userRestMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
 
    // New: update doctor
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable("id") long id, @RequestBody CreateUserRequest request) {
        try {
            User doctor = userRestMapper.toDomain(request);
            // ensure role is DOCTOR inside use case
            humanResourcesUseCase.updateDoctor(id, doctor);
            // return the updated representation: map request to response (id may be same)
            UserResponse res = userRestMapper.toResponse(doctor);
            res.setId(id);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}