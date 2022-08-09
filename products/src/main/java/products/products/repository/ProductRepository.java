package products.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import products.products.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
}
