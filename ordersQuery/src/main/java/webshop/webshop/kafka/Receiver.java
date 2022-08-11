package webshop.webshop.kafka;

import webshop.webshop.domain.Order;
import webshop.webshop.repository.OrderQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class Receiver {

    @Autowired
    OrderQueryRepository orderRepository;


    @KafkaListener(topics = {"orderTopic"})
    public void receiveOrder(@Payload OrderDTO orderDTO) {
        System.out.println("Received "+orderDTO);
        orderRepository.save(OrderAdapter.getOrderFromOrderDTO(orderDTO));
    }

    @KafkaListener(topics = {"deleteOrderTopic"})
    public void receiveDeleteOrder(@Payload OrderDTO orderDTO) {
        System.out.println("Received Order to be deleted"+orderDTO);
        orderRepository.deleteById(orderDTO.getOrderNumber());
    }
}
