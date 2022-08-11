package webshop.webshop.service;

import webshop.webshop.kafka.OrderDTO;

import java.util.Collection;

public interface OrderQueryService {
    OrderDTO getOrder(long orderNumber);
    Collection<OrderDTO> getAllOrders();

}
