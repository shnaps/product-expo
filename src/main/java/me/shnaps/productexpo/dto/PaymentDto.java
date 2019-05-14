package me.shnaps.productexpo.dto;

import me.shnaps.productexpo.entity.Payment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class PaymentDto {
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

    public PaymentDto() {
    }

    public PaymentDto(String cardNumber, LocalDate expireDate, String cvv, String paymentAddress) {
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

    public Payment transform() {
        return new Payment(cardNumber, expireDate, cvv, paymentAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto that = (PaymentDto) o;
        return Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(expireDate, that.expireDate) &&
                Objects.equals(cvv, that.cvv) &&
                Objects.equals(paymentAddress, that.paymentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, expireDate, cvv, paymentAddress);
    }
}
