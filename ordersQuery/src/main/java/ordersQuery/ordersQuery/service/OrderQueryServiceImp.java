package ordersQuery.ordersQuery.service;

import ordersQuery.ordersQuery.domain.Order;
import ordersQuery.ordersQuery.repository.OrderRepository;
import ordersQuery.ordersQuery.kafka.OrderAdapter;
import ordersQuery.ordersQuery.kafka.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderQueryServiceImp implements OrderQueryService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDTO getOrder(long orderNumber) {
        Order order = orderRepository.findById(orderNumber).get();
        if(order == null){
            System.out.println("No Order found "+orderNumber+" with this id.");
        }
        return OrderAdapter.getOrderDTOFromOrder(order);
    }

    @Override
    public Collection<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderAdapter.getOrderDTOListFromOrderList(orders);
    }
}
