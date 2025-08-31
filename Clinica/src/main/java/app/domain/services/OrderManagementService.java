package app.domain.services;

import app.domain.model.Order;
import app.domain.port.out.OrderRepository;
import app.domain.valueobject.Id;

import java.util.List;

public class OrderManagementService {
    private final OrderRepository orderRepository;

    public OrderManagementService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getOrdersByPatient(Id patientId) {
        return orderRepository.findByPatientId(patientId);
    }
}

