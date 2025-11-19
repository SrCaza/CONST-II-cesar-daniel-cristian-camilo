package app.adapter.in.rest.controllers;
 
import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.HumanResourcesUseCase;
import app.application.usecases.PatientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import app.domain.model.User;
import app.application.exceptions.EntityNotFoundException;
 
import java.util.List;
import java.util.stream.Collectors;
 
 
@RestController
@RequestMapping("/api/patient")
@PreAuthorize("permitAll()")
public class PatientController {
 
    @Autowired
    private UserRestMapper userRestMapper;
 
    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;
 
    @Autowired
    private PatientUseCase patientUseCase;
 
    @PostMapping("/users")
    public ResponseEntity<UserResponse> createPatient(@RequestBody CreateUserRequest request) throws Exception {
        User patient = userRestMapper.toDomain(request);
        humanResourcesUseCase.createPatient(patient);
        return new ResponseEntity<>(userRestMapper.toResponse(patient), HttpStatus.CREATED);
    }
 
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> findAllPatients() {
        List<User> patients = patientUseCase.findAllPatients();
        List<UserResponse> res = patients.stream().map(userRestMapper::toResponse).collect(Collectors.toList());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
 
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable("id") long id, @RequestBody CreateUserRequest request) {
        try {
            User patient = userRestMapper.toDomain(request);
            patientUseCase.updatePatient(id, patient);
            UserResponse resp = userRestMapper.toResponse(patient);
            resp.setId(id);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") long id) {
        try {
            patientUseCase.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}