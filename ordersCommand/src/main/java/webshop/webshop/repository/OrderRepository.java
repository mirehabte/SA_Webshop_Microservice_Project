package webshop.webshop.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import webshop.webshop.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.webshop.domain.Product;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    @Query("{'customer.customerNumber'::#{#customerNumber}}")
    List<Order> findOrderByCustomerNumber(@Param("customerNumber") long customerNumber);

    @Query("{'products':{$elemMatch:{'productNumber'::#{#productNumber}}}}")
    List<Order> findOrderByProductNumber(@Param("productNumber") long productNumber);
}
