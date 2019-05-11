package me.shnaps.productexpo.dto;

import me.shnaps.productexpo.entity.Payment;

import java.time.LocalDate;

public class PaymentDto {
    private String cardNumber;
    private LocalDate expireDate;
    private Integer cvv;
    private String paymentAddress;

    public PaymentDto() {
    }

    public PaymentDto(String cardNumber, LocalDate expireDate, Integer cvv, String paymentAddress) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.paymentAddress = paymentAddress;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public Payment transform() {
        return new Payment(cardNumber, expireDate, cvv, paymentAddress);
    }
}
