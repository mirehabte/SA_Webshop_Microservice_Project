package webshop.webshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.webshop.domain.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, Long> {
}
