package ordersQuery.ordersQuery.service;

import ordersQuery.ordersQuery.kafka.OrderDTO;

import java.util.Collection;

public interface OrderQueryService {
    OrderDTO getOrder(long orderNumber);
    Collection<OrderDTO> getAllOrders();
}
