package webshop.webshop.service;

import webshop.webshop.domain.Customer;
import webshop.webshop.domain.Order;
import webshop.webshop.domain.Product;
import webshop.webshop.kafka.Sender;
import webshop.webshop.repository.OrderRepository;
import webshop.webshop.kafka.OrderAdapter;
import webshop.webshop.kafka.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    Sender sender;

    @Override
    public OrderDTO add(OrderDTO orderDTO) {
        Order order = createOrder(orderDTO);
        orderRepository.save(order);
        sender.send(OrderAdapter.getOrderDTOFromOrder(order));
        System.out.println("Sending "+order);
        return OrderAdapter.getOrderDTOFromOrder(order);
    }

    @Override
    public void delete(long orderNumber) {
        Order order = orderRepository.findById(orderNumber).get();
        if(order == null){
            System.out.println("Order with "+orderNumber+" not found.");
        }
        sender.sendDeleteOrder(OrderAdapter.getOrderDTOFromOrder(order));
        System.out.println("Sending to delete "+order);
        orderRepository.delete(order);
    }

    @Override
    public void update(long orderNumber, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(orderNumber);
        if(optionalOrder.isPresent()){
            Order order = OrderAdapter.getOrderFromOrderDTO(orderDTO);
            orderRepository.save(order);
            sender.send(OrderAdapter.getOrderDTOFromOrder(order));
            System.out.println("Sending "+order);
        }
    }
    @Override
    public OrderDTO getOrder(long orderNumber) {
        Order order = orderRepository.findById(orderNumber).get();
        if(order == null){
            System.out.println("No Order found "+orderNumber+" with this id.");
        }
        return OrderAdapter.getOrderDTOFromOrder(order);
    }


    public Order createOrder(OrderDTO orderDTO){
        Random random = new Random();
        List<Product> productList = new ArrayList<>();
        Order order = OrderAdapter.getOrderFromOrderDTO(orderDTO);
        double totalPrice = calculateTotalPrice(order.getProducts());
        Customer newCustomer = new Customer(order.getCustomer().getCustomerNumber(),
                order.getCustomer().getName());

        for(Product product : order.getProducts()){
            Product newProduct = new Product(product.getProductNumber(),
                    product.getName(), product.getPrice(), product.getQuantity());
            productList.add(newProduct);
        }
        Order newOrder = new Order(order.getOrderNumber(), order.getDate(), totalPrice,
                productList, newCustomer);

        return newOrder;
    }

    public double calculateTotalPrice(List<Product> products){
        double sum = 0.0;

        for(Product product : products){
            sum = sum + product.getPrice();
            System.out.println("price "+sum);
        }
        return sum;
    }

}
