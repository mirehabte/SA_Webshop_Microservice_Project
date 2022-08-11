package webshop.webshop.kafka;



public class ProductDTO {
    private long productNumber;
    private String name;
    private double price;


    public ProductDTO(){}

    public ProductDTO(long productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
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


    @Override
    public String toString() {
        return "Product{" +
                "customerNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
