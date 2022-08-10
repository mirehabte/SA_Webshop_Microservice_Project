package ordersCommand.ordersCommand.repository;

import ordersCommand.ordersCommand.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
}
