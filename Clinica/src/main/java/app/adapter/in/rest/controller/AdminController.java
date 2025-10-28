package app.adapter.in.rest.controller;

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
	    private StaffUseCase staffUseCase;

	    @PostMapping("/users/doctor")
	    public ResponseEntity<User> createDoctor(@RequestBody User user) throws Exception {
	        User created = staffUseCase.CreateDoctor(user);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @PostMapping("/users/seller")
	    public ResponseEntity<User> createSeller(@RequestBody User user) throws Exception {
	        User created = staffUseCase.createNurse(user);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }
	}



