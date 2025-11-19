package app.adapter.in.rest.controllers;
 
import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.HumanResourcesUseCase;
import app.application.usecases.NurseUseCase;
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
@RequestMapping("/api/nurse")
@PreAuthorize("hasRole('HUMAN_RESOURCES') or hasRole('ADMINISTRATIVE_STAFF')")
public class NurseController {
 
    @Autowired
    private UserRestMapper userRestMapper;
 
    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;
 
    @Autowired
    private NurseUseCase nurseUseCase;
 
    @PostMapping("/users")
    public ResponseEntity<UserResponse> createNurse(@RequestBody CreateUserRequest request) throws Exception {
        User nurse = userRestMapper.toDomain(request);
        humanResourcesUseCase.createNurse(nurse);
        return new ResponseEntity<>(userRestMapper.toResponse(nurse), HttpStatus.CREATED);
    }
 
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> findAllNurses() {
        List<User> nurses = nurseUseCase.findAllNurses();
        List<UserResponse> res = nurses.stream().map(userRestMapper::toResponse).collect(Collectors.toList());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
 
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateNurse(@PathVariable("id") long id, @RequestBody CreateUserRequest request) {
        try {
            User nurse = userRestMapper.toDomain(request);
            nurseUseCase.updateNurse(id, nurse);
            UserResponse resp = userRestMapper.toResponse(nurse);
            resp.setId(id);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteNurse(@PathVariable("id") long id) {
        try {
            nurseUseCase.deleteNurse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}