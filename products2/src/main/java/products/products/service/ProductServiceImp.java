package products.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.products.integration.kafka.Sender;
import products.products.domain.Product;
import products.products.repository.ProductRepository;
import products.products.service.DTOs.ProductAdapter;
import products.products.service.DTOs.ProductDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Sender sender;

    @Override
    public void add(ProductDTO productDTO) {
       Product product = ProductAdapter.getProductFromProductDTO(productDTO);
       productRepository.save(product);
       sender.send(ProductAdapter.getProductDTOFromProduct(product));
    }

    @Override
    public void delete(long productNumber) {
        productRepository.deleteById(productNumber);
    }

    @Override
    public void update(long productNumber, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(productNumber);
        if(optionalProduct.isPresent()){
            Product product = ProductAdapter.getProductFromProductDTO(productDTO);
            productRepository.save(product);
            sender.send(ProductAdapter.getProductDTOFromProduct(product));
        }
    }

    @Override
    public ProductDTO getProduct(long productNumber) {
        Product product = productRepository.findById(productNumber).get();
        if(product == null){
            System.out.println("No product found with this "+productNumber+" id.");
        }
        return ProductAdapter.getProductDTOFromProduct(product);
    }

    @Override
    public Collection<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductAdapter.getProductDTOListFromProductList(products);
    }
}
