package products.products.service;

import products.products.domain.Product;
import products.products.service.DTOs.ProductDTO;

import java.util.Collection;

public interface ProductService {
    void add(ProductDTO productDTO);
    void delete(long productNumber);
    void update(long productNumber, ProductDTO productDTO);
    ProductDTO getProduct(long productNumber);
    Collection<ProductDTO> getAllProducts();
}
