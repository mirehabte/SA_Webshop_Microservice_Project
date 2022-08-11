package webshop.webshop.service;

import webshop.webshop.domain.Order;
import webshop.webshop.repository.OrderQueryRepository;
import webshop.webshop.kafka.OrderAdapter;
import webshop.webshop.kafka.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryServiceImp implements OrderQueryService{

    @Autowired
    OrderQueryRepository orderRepository;

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
