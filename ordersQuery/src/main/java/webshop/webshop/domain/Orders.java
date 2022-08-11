package webshop.webshop.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Orders {
    private Collection<Order> orderList = new ArrayList<>();

    public Orders(Collection<Order> orderList) {
        this.orderList = orderList;
    }

    public Collection<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderList=" + orderList +
                '}';
    }
}
