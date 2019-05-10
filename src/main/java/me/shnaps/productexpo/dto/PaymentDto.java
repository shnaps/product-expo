package me.shnaps.productexpo.dto;

import me.shnaps.productexpo.entity.Payment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PaymentDto {
    private String cardNumber;
    private LocalDateTime expireDate;
    private Integer cvv;
    private String paymentAddress;

    public PaymentDto(String cardNumber, LocalDateTime expireDate, Integer cvv, String paymentAddress) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.paymentAddress = paymentAddress;
    }

    public Payment transform() {
        return new Payment(cardNumber, expireDate, cvv, paymentAddress);
    }
}
