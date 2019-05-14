package me.shnaps.productexpo.dto;

import me.shnaps.productexpo.entity.Payment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PaymentDto {
    @NotNull(message = "Card number can't be null")
    @Pattern(regexp = "\\n{16}", message = "Card number must be 16 symbols")
    private String cardNumber;
    @NotNull(message = "Expire date can't be null")
    private LocalDate expireDate;
    @NotNull(message = "CVV can't be null")
    @Pattern(regexp = "\\n{3}", message = "CVV  must be 3 symbols")
    private Integer cvv;
    @NotNull(message = "Payment can't be null")
    @Size(min = 10, max = 50, message = "Payment address must be between 10 and 50 symbols")
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
