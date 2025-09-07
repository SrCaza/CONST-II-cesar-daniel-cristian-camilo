package app.domain.port.in.Order;

public class CreateOrder {
	
	private final OrderRepository orderRepository;
	
    public CreateOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

}
