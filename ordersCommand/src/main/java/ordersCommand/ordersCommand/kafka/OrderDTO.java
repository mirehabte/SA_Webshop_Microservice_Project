package ordersCommand.ordersCommand.kafka;

import ordersCommand.ordersCommand.domain.Customer;
import ordersCommand.ordersCommand.domain.Product;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {
    private long orderNumber;
    private LocalDate date;
    private double price;
    private List<Product> products;
    private Customer customer;

    public OrderDTO(){}

    public OrderDTO(long orderNumber, LocalDate date, double price, List<Product> products, Customer customer) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.price = price;
        this.products = products;
        this.customer = customer;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", date=" + date +
                ", price=" + price +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
