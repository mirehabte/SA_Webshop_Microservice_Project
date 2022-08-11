package webshop.webshop.domain;

public class Product {
    private long productNumber;
    private String name;
    private double price;

    private int quantity;

    public Product(){}

    public Product(long productNumber, String name, double price, int quantity) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "customerNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

