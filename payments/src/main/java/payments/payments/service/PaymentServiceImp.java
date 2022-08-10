package payments.payments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payments.payments.domain.Payment;
import payments.payments.repository.PaymentRepository;
import payments.payments.service.DTOs.PaymentAdapter;
import payments.payments.service.DTOs.PaymentDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImp implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void add(PaymentDTO paymentDTO) {
        Payment payment = PaymentAdapter.getPaymentFromPaymentDTO(paymentDTO);
        paymentRepository.save(payment);
    }

    @Override
    public void delete(long paymentNumber) {
        paymentRepository.deleteById(paymentNumber);
    }

    @Override
    public void update(long paymentNumber, PaymentDTO paymentDTO) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentNumber);
        if(optionalPayment.isPresent()){
            paymentRepository.save(PaymentAdapter.getPaymentFromPaymentDTO(paymentDTO));
        }
    }

    @Override
    public PaymentDTO getPayment(long paymentNumber) {
        Payment payment = paymentRepository.findById(paymentNumber).get();
        if(payment == null){
            System.out.println("No payment found with this "+paymentNumber+" id.");
        }
        return PaymentAdapter.getPaymentDTOFromPayment(payment);
    }

    @Override
    public Collection<PaymentDTO> getAllPayments() {
        List<Payment> paymentList = paymentRepository.findAll();
        return PaymentAdapter.getPaymentDTOListFromPaymentList(paymentList);
    }

}
