package app.adapter.out.persistence;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.stereotype.Service;
 
import app.domain.model.Order;
import app.domain.repositories.OrderRepository;
import app.domain.valueobject.Id;
 
@Service
public class OrderAdapter implements OrderRepository{
 
	@Override
	public void createOrder(Order order) {
		// TODO: implement persistence logic
	}
 
	@Override
	public void save(Order order) {
		// TODO: implement persistence logic
	}
 
	@Override
	public List<Order> DeleteOrder(Order deleteOrder) {
		// TODO: implement delete logic
		return new ArrayList<>();
	}
 
	@Override
	public List<Order> findByPatientId(Id patientId) {
		// TODO: implement query by patient id
		return new ArrayList<>();
	}
 
	@Override
	public List<Order> findAll() {
		// TODO: implement find all
		return new ArrayList<>();
	}
 
	@Override
	public Optional<Order> findById(Long id) {
		// TODO: implement find by id
		return Optional.empty();
	}
 
	@Override
	public void deleteById(Long id) {
		// TODO: implement delete by id
	}
 
}