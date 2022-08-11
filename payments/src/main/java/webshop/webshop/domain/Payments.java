package webshop.webshop.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Payments {
    private Collection<Payment> paymentList = new ArrayList<>();

    public Payments(Collection<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Collection<Payment> getPaymentList() {
        return paymentList;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentList=" + paymentList +
                '}';
    }
}
