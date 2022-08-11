package webshop.webshop.service;

import webshop.webshop.kafka.OrderDTO;

public interface OrderService {
    OrderDTO add(OrderDTO orderDTO) throws InterruptedException;
    void delete(long orderNumber);
    void update(long orderNumber, OrderDTO orderDTO);

    OrderDTO getOrder(long orderNumber);
}
