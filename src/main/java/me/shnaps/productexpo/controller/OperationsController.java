package me.shnaps.productexpo.controller;

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
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }
}
