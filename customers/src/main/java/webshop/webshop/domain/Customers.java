package webshop.webshop.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Customers {
    private Collection<Customer> customers = new ArrayList<>();
    public Customers(){}

    public Customers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }
}
