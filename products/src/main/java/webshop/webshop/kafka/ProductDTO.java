package webshop.webshop.kafka;

import webshop.webshop.domain.Supplier;

public class ProductDTO {
    private long productNumber;
    private String name;
    private double price;
    private Supplier supplier;

    public ProductDTO(){}

    public ProductDTO(long productNumber, String name, double price, Supplier supplier) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "customerNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                '}';
    }
}
