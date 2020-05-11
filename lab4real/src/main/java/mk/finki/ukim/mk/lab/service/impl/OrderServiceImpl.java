package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private static long ID = 0;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String pizzaType, String pizzaSize, String clientName, String address) {
        Order order = new Order();
        order.setPizzaType(pizzaType);
        order.setPizzaSize(pizzaSize);
        order.setClientName(clientName);
        order.setClientAddress(address);

        order.setOrderId(ID);
        OrderServiceImpl.ID++;


        return order;
    }
}
