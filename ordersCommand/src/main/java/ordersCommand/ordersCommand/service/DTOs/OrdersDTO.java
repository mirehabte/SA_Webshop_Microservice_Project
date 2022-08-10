package ordersCommand.ordersCommand.service.DTOs;

import java.util.ArrayList;
import java.util.Collection;

public class OrdersDTO {
    private Collection<OrderDTO> orderDTOList = new ArrayList<>();

    public OrdersDTO(Collection<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    public Collection<OrderDTO> getOrderDTOList() {
        return orderDTOList;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "orderDTOList=" + orderDTOList +
                '}';
    }
}
