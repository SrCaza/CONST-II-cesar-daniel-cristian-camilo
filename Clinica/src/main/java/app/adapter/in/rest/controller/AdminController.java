package app.adapter.in.rest.controller;

import app.adapter.in.builder.UserBuilder;
import app.adapter.in.rest.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.applicacion.usecase.StaffUseCase;
import app.domain.model.User;



@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")

public class AdminController {

@Autowired
private UserBuilder builder;
	    @Autowired
	    private StaffUseCase staffUseCase;

	    @PostMapping("/users/doctor")
	    public ResponseEntity<User> createDoctor(@RequestBody UserRequest request) throws Exception {
            User doctor = builder.build(request.getName(),request.getDocument(),request.getAge(),request.getUserName(),request.getPassword());
	        User created = staffUseCase.createDoctor(doctor);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @PostMapping("/users/nurse")
	    public ResponseEntity<User> createNurse(@RequestBody UserRequest request) throws Exception {
	        User nurse = builder.build(request.getName(), request.getDocument(), request.getAge(), request.getUserName(), request.getPassword());
            User created = staffUseCase.createNurse(nurse);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

        @PostMapping("/users/staff")
        public ResponseEntity<User> createStaff(@RequestBody UserRequest request) throws Exception {
            User staff = builder.build(request.getName(), request.getDocument(), request.getAge(), request.getUserName(), request.getPassword());
            User created = staffUseCase.createStaff(staff);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }

        @PostMapping("/users/human-resources")
        public ResponseEntity<User> createHumanResources(@RequestBody UserRequest request) throws Exception {
            User humanResources = builder.build(request.getName(), request.getDocument(), request.getAge(), request.getUserName(), request.getPassword());
            User created = staffUseCase.createHumanResources(humanResources);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }

        @PostMapping("/users/patient")
        public ResponseEntity<User> createPatient(@RequestBody UserRequest request) throws Exception {
            User patient = builder.build(request.getName(), request.getDocument(), request.getAge(), request.getUserName(), request.getPassword());
            User created = staffUseCase.createPatient(patient);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
}



