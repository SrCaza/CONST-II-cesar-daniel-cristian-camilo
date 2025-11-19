package app.adapter.in.rest.controllers;
 
import app.application.exceptions.EntityNotFoundException;
import app.application.usecases.OrderUseCase;
import app.domain.model.Order;
import app.domain.valueobject.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/order")
@PreAuthorize("hasRole('DOCTOR') or hasRole('ADMINISTRATIVE_STAFF') or hasRole('HUMAN_RESOURCES')")
public class OrderController {
 
    @Autowired
    private OrderUseCase orderUseCase;
 
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderUseCase.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
 
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Order>> getOrdersByPatient(@PathVariable("id") String id) {
        Id patientId = new Id(id);
        List<Order> orders = orderUseCase.getOrdersByPatient(patientId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
 
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> orders = orderUseCase.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
 
    @PutMapping("/orders/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        try {
            orderUseCase.updateOrder(id, order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        try {
            orderUseCase.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}