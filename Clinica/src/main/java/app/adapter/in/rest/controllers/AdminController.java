package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.HumanResourcesUseCase;
import app.application.usecases.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import app.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAnyRole('ADMIN', 'HUMAN_RESOURCES')")
public class AdminController {

    @Autowired
    private UserRestMapper userRestMapper;

    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;

    @Autowired
    private UserUseCase userUseCase;

    // ==================== CREAR USUARIOS ====================
    
    @PostMapping("/users/doctor")
    public ResponseEntity<UserResponse> createDoctor(@RequestBody CreateUserRequest request) throws Exception {
        User doctor = userRestMapper.toDomain(request);
        humanResourcesUseCase.createDoctor(doctor);
        return new ResponseEntity<>(userRestMapper.toResponse(doctor), HttpStatus.CREATED);
    }

    @PostMapping("/users/nurse")
    public ResponseEntity<UserResponse> createNurse(@RequestBody CreateUserRequest request) throws Exception {
        User nurse = userRestMapper.toDomain(request);
        humanResourcesUseCase.createNurse(nurse);
        return new ResponseEntity<>(userRestMapper.toResponse(nurse), HttpStatus.CREATED);
    }

    @PostMapping("/users/staff")
    public ResponseEntity<UserResponse> createStaff(@RequestBody CreateUserRequest request) throws Exception {
        User staff = userRestMapper.toDomain(request);
        humanResourcesUseCase.createStaff(staff);
        return new ResponseEntity<>(userRestMapper.toResponse(staff), HttpStatus.CREATED);
    }

    @PostMapping("/users/human-resources")
    public ResponseEntity<UserResponse> createHumanResources(@RequestBody CreateUserRequest request) throws Exception {
        User humanResources = userRestMapper.toDomain(request);
        humanResourcesUseCase.createHumanResources(humanResources);
        return new ResponseEntity<>(userRestMapper.toResponse(humanResources), HttpStatus.CREATED);
    }

    @PostMapping("/users/patient")
    public ResponseEntity<UserResponse> createPatient(@RequestBody CreateUserRequest request) throws Exception {
        User patient = userRestMapper.toDomain(request);
        humanResourcesUseCase.createPatient(patient);
        return new ResponseEntity<>(userRestMapper.toResponse(patient), HttpStatus.CREATED);
    }

    // ==================== BUSCAR USUARIOS ====================
    
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userUseCase.findAll();
        List<UserResponse> response = users.stream()
            .map(userRestMapper::toResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable long id) throws Exception {
        Optional<User> user = userUseCase.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(userRestMapper.toResponse(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) throws Exception {
        Optional<User> user = userUseCase.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(userRestMapper.toResponse(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/document/{document}")
    public ResponseEntity<UserResponse> getUserByDocument(@PathVariable long document) throws Exception {
        Optional<User> user = userUseCase.findByDocument(document);
        if (user.isPresent()) {
            return ResponseEntity.ok(userRestMapper.toResponse(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    // ==================== ACTUALIZAR USUARIOS ====================
    
    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable long id, 
            @RequestBody CreateUserRequest request) throws Exception {
        
        User updatedUser = userRestMapper.toDomain(request);
        updatedUser.setId(id);
        userUseCase.update(updatedUser);
        
        return ResponseEntity.ok(userRestMapper.toResponse(updatedUser));
    }

    // ==================== ELIMINAR USUARIOS ====================
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) throws Exception {
        userUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}



