package webshop.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.webshop.domain.Payment;
import webshop.webshop.kafka.Sender;
import webshop.webshop.repository.PaymentRepository;
import webshop.webshop.kafka.PaymentAdapter;
import webshop.webshop.kafka.PaymentDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImp implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    Sender sender;

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
            sender.send(paymentDTO);
            System.out.println("Sending "+paymentDTO);
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
