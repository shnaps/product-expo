package me.shnaps.productexpo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String cardNumber;
    private LocalDateTime expireDate;
    private Integer cvv;
    private String paymentAddress;

    public Payment(String cardNumber, LocalDateTime expireDate, Integer cvv, String paymentAddress) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.paymentAddress = paymentAddress;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expireDate=" + expireDate +
                ", cvv=" + cvv +
                ", paymentAddress='" + paymentAddress + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
