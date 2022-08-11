package webshop.webshop.kafka;


import java.util.ArrayList;
import java.util.Collection;

public class ProductsDTO {
    private Collection<ProductDTO> products = new ArrayList<>();

    public ProductsDTO(Collection<ProductDTO> products) {
        this.products = products;
    }

    public Collection<ProductDTO> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductsDTO{" +
                "products=" + products +
                '}';
    }
}
