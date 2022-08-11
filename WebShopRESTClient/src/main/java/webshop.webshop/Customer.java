package webshop.webshop;



public class Customer {

    private long customerNumber;
    private String name;
    private Address address;
    private Contact contact;

    public Customer(){}

    public Customer(long customerNumber, String name, Address address, Contact contact) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.address = address;
        this.contact = contact;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }
}
