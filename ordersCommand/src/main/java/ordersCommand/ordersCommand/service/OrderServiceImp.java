package ordersCommand.ordersCommand.service;

import ordersCommand.ordersCommand.domain.Customer;
import ordersCommand.ordersCommand.domain.Order;
import ordersCommand.ordersCommand.domain.Product;
import ordersCommand.ordersCommand.repository.OrderRepository;
import ordersCommand.ordersCommand.service.DTOs.OrderAdapter;
import ordersCommand.ordersCommand.service.DTOs.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDTO add(OrderDTO orderDTO) {
        Order order = createOrder(orderDTO);
        orderRepository.save(order);
        return OrderAdapter.getOrderDTOFromOrder(order);
    }

    @Override
    public void delete(long orderNumber) {
        orderRepository.deleteById(orderNumber);
    }

    @Override
    public void update(long orderNumber, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(orderNumber);
        if(optionalOrder.isPresent()){
            Order order = OrderAdapter.getOrderFromOrderDTO(orderDTO);
            orderRepository.save(order);
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

    @Override
    public Collection<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderAdapter.getOrderDTOListFromOrderList(orders);
    }

    public Order createOrder(OrderDTO orderDTO){
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
        newOrder.setPrice(totalPrice);
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
