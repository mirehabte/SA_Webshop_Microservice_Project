package ordersQuery.ordersQuery.kafka;

import ordersQuery.ordersQuery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @Autowired
    OrderRepository orderRepository;


    @KafkaListener(topics = {"orderTopic"})
    public void receiveOrder(@Payload OrderDTO orderDTO) {
        System.out.println("Received "+orderDTO);
    }
//
//    @KafkaListener(topics = {"deleteOrderTopic"})
//    public void receiveDeleteOrder(@Payload OrderDTO orderDTO) {
//        System.out.println("Received Order to be deleted"+orderDTO);
//    }
}
