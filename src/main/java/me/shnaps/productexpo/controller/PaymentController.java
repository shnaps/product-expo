package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.PaymentDto;
import me.shnaps.productexpo.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaymentController {
    private static Payment finalPayment;

    public static Payment getFinalPayment() {
        return finalPayment;
    }

    public static void setFinalPayment(Payment finalPayment) {
        PaymentController.finalPayment = finalPayment;
    }

    @PostMapping("/payment")
    public ResponseEntity createPayment(@Valid @RequestBody PaymentDto payment) {
        setFinalPayment(payment.transform());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Payment with card # *");
        String cardNumber = finalPayment.getCardNumber();
        stringBuilder.append(cardNumber.substring(cardNumber.length() - 4));
        stringBuilder.append(" cached");
        return new ResponseEntity(stringBuilder.toString(), HttpStatus.OK);
    }
}
