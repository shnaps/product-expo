package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.PaymentDto;
import me.shnaps.productexpo.entity.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaymentController {
    public static Payment finalPayment;

    @PostMapping("/payment")
    public String createPayment(@Valid @RequestBody PaymentDto payment) {
        finalPayment = payment.transform();
        return "Payment cached";
    }
}
