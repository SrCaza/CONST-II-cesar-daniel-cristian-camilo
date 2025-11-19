package app.application.usecases;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import app.domain.model.Order;
import app.domain.repositories.OrderRepository;
import app.domain.valueobject.Id;
import app.application.exceptions.EntityNotFoundException;
 
@Service
public class OrderUseCase {
	
	@Autowired
	private OrderRepository orderRepository;
	
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
 
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
 
    public void updateOrder(Long id, Order order) {
        Optional<Order> opt = orderRepository.findById(id);
        if (!opt.isPresent()) {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
        order.setId(id);
        orderRepository.save(order);
    }
 
    public void deleteOrder(Long id) {
        Optional<Order> opt = orderRepository.findById(id);
        if (!opt.isPresent()) {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
 
    public List<Order>DeleteOrder(Order deleteOrder){
		return null;
	}
    public List<Order> getOrdersByPatient(Id patientId) {
        return orderRepository.findByPatientId(patientId);
    }
 
}