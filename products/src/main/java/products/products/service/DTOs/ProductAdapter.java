package products.products.service.DTOs;

import products.products.domain.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductAdapter {
    public static Product getProductFromProductDTO(ProductDTO productDTO){
        return new Product(productDTO.getProductNumber(), productDTO.getName(),
                productDTO.getPrice(), productDTO.getSupplier());
    }

    public static ProductDTO getProductDTOFromProduct(Product product){
        return new ProductDTO(product.getProductNumber(), product.getName(),
                product.getPrice(), product.getSupplier());
    }

    public static Collection<ProductDTO> getProductDTOListFromProductList(List<Product> productList){
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product : productList){
            productDTOS.add(getProductDTOFromProduct(product));
        }
        return productDTOS;
    }
}
