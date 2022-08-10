package ordersCommand.ordersCommand.service;

import ordersCommand.ordersCommand.kafka.OrderDTO;

public interface OrderService {
    OrderDTO add(OrderDTO orderDTO);
    void delete(long orderNumber);
    void update(long orderNumber, OrderDTO orderDTO);

    OrderDTO getOrder(long orderNumber);
}
