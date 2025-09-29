package app.applicacion.usecase;

import java.util.List;

import app.domain.model.Order;
import app.domain.repositories.OrderRepository;
import app.domain.valueobject.Id;

public class OrderUseCase {
	
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
