package webshop.webshop.repository;

import webshop.webshop.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQueryRepository extends MongoRepository<Order, Long> {
}
