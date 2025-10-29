package app.adapter.in.rest.controller;

import app.adapter.in.builder.UserBuilder;
import app.adapter.in.rest.request.UserRequiest;
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
	    public ResponseEntity<User> createDoctor(@RequestBody UserRequiest request) throws Exception {
            User user = builder.build(request.getName(),request.getDocument(),request.getAge(),request.getUserName(),request.getPassword());
	        User created = staffUseCase.CreateDoctor(user);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	   // @PostMapping("/users/nurse")
	    //public ResponseEntity<User> createSeller(@RequestBody UserRequiest user) throws Exception {
	        //User nurse = builder.build(request.);
            //User created = staffUseCase.createNurse(nurse);
	        //return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }
	//}



