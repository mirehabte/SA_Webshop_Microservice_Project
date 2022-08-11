package webshop.webshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.webshop.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
}
