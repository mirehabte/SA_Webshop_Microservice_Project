package ordersQuery.ordersQuery.service.DTOs;


import ordersQuery.ordersQuery.domain.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderAdapter {
    public static Order getOrderFromOrderDTO(OrderDTO orderDTO){
        return new Order(orderDTO.getOrderNumber(), orderDTO.getDate(), orderDTO.getPrice(),
                orderDTO.getProducts(), orderDTO.getCustomer());
    }

    public static OrderDTO getOrderDTOFromOrder(Order order){
        return new OrderDTO(order.getOrderNumber(), order.getDate(), order.getPrice(),
                order.getProducts(), order.getCustomer());
    }

    public static Collection<OrderDTO> getOrderDTOListFromOrderList(List<Order> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order : orders){
            orderDTOS.add(getOrderDTOFromOrder(order));
        }
        return orderDTOS;
    }

}
