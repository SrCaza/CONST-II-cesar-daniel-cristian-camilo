package app.adapter.in.rest.controllers;


import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.HumanResourcesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.domain.model.User;



@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")

public class AdminController {

        @Autowired
        private UserRestMapper userRestMapper;

        @Autowired
	    private HumanResourcesUseCase humanResourcesUseCase;

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
}



