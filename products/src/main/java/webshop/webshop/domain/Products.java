package webshop.webshop.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Products {
    private Collection<Product> products = new ArrayList<>();

    public Products(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + products +
                '}';
    }
}
