package webshop.webshop.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import webshop.webshop.domain.Order;
import webshop.webshop.domain.Product;
import webshop.webshop.repository.OrderRepository;

import java.util.List;

@Service
public class Receiver {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    Sender sender;

    @KafkaListener(topics = {"customerTopic"})
    public void receiveCustomer(@Payload CustomerDTO customerDTO) {
        System.out.println("Received "+customerDTO);
        List<Order> orders = orderRepository.findOrderByCustomerNumber(customerDTO.getCustomerNumber());
        for(Order order: orders){
            order.getCustomer().setName(customerDTO.getName());
            orderRepository.save(order);
            sender.send(OrderAdapter.getOrderDTOFromOrder(order));
            System.out.println("Sending to queryOrder "+order);
        }
    }


    @KafkaListener(topics = {"productTopic"})
    public void receiveProduct(@Payload ProductDTO productDTO) {
        System.out.println("Received "+productDTO);
        List<Order> orders = orderRepository.findOrderByProductNumber(productDTO.getProductNumber());
        System.out.println(orders);
        for(Order order: orders){
           for(Product product : order.getProducts()){
               if(product.getProductNumber() == productDTO.getProductNumber()){
                   product.setName(productDTO.getName());
               }
           }
           orderRepository.save(order);
           sender.send(OrderAdapter.getOrderDTOFromOrder(order));
            System.out.println("Sending to queryOrder "+order);
        }
    }

    @KafkaListener(topics = {"paymentTopic"})
    public void receivePayment(@Payload PaymentDTO paymentDTO) {
        Order order = orderRepository.findById(paymentDTO.getOrderNumber()).get();
        if(order != null){
            order.setPrice(paymentDTO.getAmount());
            orderRepository.save(order);
            sender.send(OrderAdapter.getOrderDTOFromOrder(order));
            System.out.println("Sending to queryOrder "+order);
        }
    }
}
