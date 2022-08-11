package webshop.webshop;

public class ProductAdapter {
    public static Product getProductFromProductDTO(ProductDTO productDTO){
        return new Product(productDTO.getProductNumber(), productDTO.getName(),
                productDTO.getPrice(), productDTO.getSupplier());
    }

    public static ProductDTO getProductDTOFromProduct(Product product){
        return new ProductDTO(product.getProductNumber(), product.getName(),
                product.getPrice(), product.getSupplier());
    }

}
