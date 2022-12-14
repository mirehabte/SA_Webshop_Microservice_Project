package webshop.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.webshop.kafka.Sender;
import webshop.webshop.domain.Product;
import webshop.webshop.repository.ProductRepository;
import webshop.webshop.kafka.ProductAdapter;
import webshop.webshop.kafka.ProductDTO;

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
            System.out.println("Sending "+product);
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
