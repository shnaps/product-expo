package me.shnaps.productexpo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import me.shnaps.productexpo.entity.Payment;

import java.time.LocalDateTime;

public class PaymentDto {
    private String cardNumber;
    //not properly working
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy")
    private LocalDateTime expireDate;
    private Integer cvv;
    private String paymentAddress;

    public PaymentDto() {
    }

    public PaymentDto(String cardNumber, LocalDateTime expireDate, Integer cvv, String paymentAddress) {
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

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
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
        //problem with jackson and dates
        return new Payment(cardNumber, null, cvv, paymentAddress);
    }
}
