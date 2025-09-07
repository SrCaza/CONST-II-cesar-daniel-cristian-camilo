package app.domain.port.in.Order;

import java.util.List;

public class DeleteOrder {
	
	private final OrderRepository orderRepository;
	
    public DeleteOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
	
	public List<Order>DeleteOrder(Order deleteOrder){
		System.out.println("Orden eliminada");
		return null;
	}

}
