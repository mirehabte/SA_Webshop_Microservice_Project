package payments.payments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import payments.payments.domain.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, Long> {
}
