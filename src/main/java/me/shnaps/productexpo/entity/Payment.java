package me.shnaps.productexpo.entity;

import me.shnaps.productexpo.dto.PaymentDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @NotNull(message = "Card number can't be null")
    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 symbols")
    private String cardNumber;
    @NotNull(message = "Expire date can't be null")
    private LocalDate expireDate;
    @NotNull(message = "CVV can't be null")
    @Pattern(regexp = "\\d{3}", message = "CVV  must be 3 symbols")
    private String cvv;
    @NotNull(message = "Payment can't be null")
    @Size(min = 10, max = 50, message = "Payment address must be between 10 and 50 symbols")
    private String paymentAddress;

    public Payment() {
    }

    public Payment(String cardNumber, LocalDate expireDate, String cvv, String paymentAddress) {
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

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public PaymentDto transformToDto() {
        return new PaymentDto(this.cardNumber, this.expireDate, this.cvv, this.paymentAddress);
    }
}
