package app.domain.repositories;
 
 
import java.util.List;
import java.util.Optional;
 
import app.domain.model.Order;
import app.domain.valueobject.Id;
 
public interface OrderRepository {
	public void createOrder(Order order);
	void save(Order order);
	public List<Order>DeleteOrder(Order deleteOrder);
	public List<Order> findByPatientId(Id patientId);
	
	// New methods
	public List<Order> findAll();
	public Optional<Order> findById(Long id);
	public void deleteById(Long id);
	
 
}
 