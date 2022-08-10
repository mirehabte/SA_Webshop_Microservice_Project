package ordersCommand.ordersCommand.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
public class Order {

    @Id
    private long orderNumber;
    private LocalDate date;
    private double price;
    private List<Product> products;
    private Customer customer;

    public Order(){}

    public Order(long orderNumber, LocalDate date, double price, List<Product> products, Customer customer) {
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
