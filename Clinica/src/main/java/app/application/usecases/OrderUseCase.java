package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Order;
import app.domain.repositories.OrderRepository;
import app.domain.valueobject.Id;

@Service
public class OrderUseCase {
	
	@Autowired
	private OrderRepository orderRepository;
	
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
	public List<Order>DeleteOrder(Order deleteOrder){
		return null;
	}
    public List<Order> getOrdersByPatient(Id patientId) {
        return orderRepository.findByPatientId(patientId);
    }

}
