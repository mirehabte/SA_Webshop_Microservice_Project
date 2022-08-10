package payments.payments.service.DTOs;

import java.util.ArrayList;
import java.util.Collection;

public class PaymentsDTO {
    private Collection<PaymentDTO> paymentDTOs = new ArrayList<>();

    public PaymentsDTO(Collection<PaymentDTO> paymentDTOs) {
        this.paymentDTOs = paymentDTOs;
    }

    public Collection<PaymentDTO> getPaymentDTOs() {
        return paymentDTOs;
    }

    @Override
    public String toString() {
        return "PaymentsDTO{" +
                "paymentDTOs=" + paymentDTOs +
                '}';
    }
}
