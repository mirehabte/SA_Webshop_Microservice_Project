package webshop.webshop.domain;

public class Customer {
    private long customerNumber;
    private String name;

    public Customer(){}

    public Customer(long customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
