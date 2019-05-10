package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.PaymentDto;
import me.shnaps.productexpo.dto.UserDto;
import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.service.PaymentService;
import me.shnaps.productexpo.service.UserService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OperationsController {
    private PaymentService paymentService;
    private UserService userService;

    public OperationsController(@NonNull PaymentService paymentService, @NonNull UserService userService) {
        this.paymentService = paymentService;
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserDto user) {
        User finalUser = user.transform();
        return userService.save(finalUser);
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody PaymentDto payment) {
        Payment finalPayment = payment.transform();
        return paymentService.save(finalPayment);
    }
}
