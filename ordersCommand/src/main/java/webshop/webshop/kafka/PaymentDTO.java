package webshop.webshop.kafka;

import java.time.LocalDate;

public class PaymentDTO {
    private long paymentNumber;
    private LocalDate date;
    private double amount;
    private long orderNumber;
    private long customerNumber;

    public PaymentDTO(){}

    public PaymentDTO(long paymentNumber, LocalDate date, double amount, long orderNumber, long customerNumber) {
        this.paymentNumber = paymentNumber;
        this.date = date;
        this.amount = amount;
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
    }

    public long getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(long paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentNumber=" + paymentNumber +
                ", date=" + date +
                ", amount=" + amount +
                ", orderNumber=" + orderNumber +
                ", customerNumber=" + customerNumber +
                '}';
    }
}
