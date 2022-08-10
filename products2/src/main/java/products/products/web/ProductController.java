package products.products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.products.service.DTOs.ProductDTO;
import products.products.service.DTOs.ProductsDTO;
import products.products.service.ProductService;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        productService.add(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable long productNumber){
        ProductDTO productDTO = productService.getProduct(productNumber);
        if(productDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Product with : "+productNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        productService.delete(productNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{productNumber}")
    public ResponseEntity<?> updateProduct(@PathVariable long productNumber, @RequestBody ProductDTO productDTO){
        ProductDTO updateProductDTO = productService.getProduct(productNumber);
        if(updateProductDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Product with : "+productNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        productService.update(productNumber, productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable long productNumber){
        ProductDTO productDTO = productService.getProduct(productNumber);
        if(productDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Customer with : "+productNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        Collection<ProductDTO> productDTOList = productService.getAllProducts();
        ProductsDTO allProducts = new ProductsDTO(productDTOList);
        return new ResponseEntity<ProductsDTO>(allProducts, HttpStatus.OK);
    }
}
