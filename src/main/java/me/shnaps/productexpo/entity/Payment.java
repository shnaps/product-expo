package me.shnaps.productexpo.entity;

import me.shnaps.productexpo.dto.PaymentDto;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
    @NonNull
    @Pattern(regexp = "\\n{16}", message = "Card number must be 16 symbols")
    private String cardNumber;
    @NonNull()
    private LocalDate expireDate;
    @NonNull
    @Pattern(regexp = "\\n{3}", message = "CVV  must be 3 symbols")
    private Integer cvv;
    @NonNull
    @Size(min = 10, max = 50, message = "Payment address must be between 10 and 50 symbols")
    private String paymentAddress;

    public Payment() {
    }

    public Payment(String cardNumber, LocalDate expireDate, Integer cvv, String paymentAddress) {
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

    public PaymentDto transformToDto() {
        return new PaymentDto(this.cardNumber, this.expireDate, this.cvv, this.paymentAddress);
    }
}
