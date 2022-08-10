package payments.payments.service;

import payments.payments.service.DTOs.PaymentDTO;

import java.util.Collection;

public interface PaymentService {
    void add(PaymentDTO paymentDTO);
    void delete(long paymentNumber);
    void update(long paymentNumber, PaymentDTO paymentDTO);
    PaymentDTO getPayment(long paymentNumber);
    Collection<PaymentDTO> getAllPayments();
}
