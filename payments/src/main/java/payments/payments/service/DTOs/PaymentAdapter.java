package payments.payments.service.DTOs;

import payments.payments.domain.Payment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PaymentAdapter {
    public static Payment getPaymentFromPaymentDTO(PaymentDTO paymentDTO){
        return new Payment(paymentDTO.getPaymentNumber(), paymentDTO.getDate(),
                paymentDTO.getAmount(), paymentDTO.getOrderNumber(), paymentDTO.getCustomerNumber());
    }

    public static PaymentDTO getPaymentDTOFromPayment(Payment payment){
        return new PaymentDTO(payment.getPaymentNumber(), payment.getDate(),
                payment.getAmount(), payment.getOrderNumber(), payment.getCustomerNumber());
    }

    public static Collection<PaymentDTO> getPaymentDTOListFromPaymentList(List<Payment> payments){
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for(Payment payment: payments){
            paymentDTOS.add(getPaymentDTOFromPayment(payment));
        }
        return paymentDTOS;
    }
}
