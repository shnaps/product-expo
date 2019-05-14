package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.PaymentDto;
import me.shnaps.productexpo.entity.Payment;
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
    public String createPayment(@Valid @RequestBody PaymentDto payment) {
        setFinalPayment(payment.transform());
        return "Payment cached";
    }
}
