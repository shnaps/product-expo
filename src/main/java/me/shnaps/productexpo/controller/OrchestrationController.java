package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.ResultDto;
import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.service.OrchestrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestrationController {

    private final OrchestrationService service;

    public OrchestrationController(OrchestrationService service) {
        this.service = service;
    }

    @GetMapping("/proceed")
    public ResultDto proceedCreation() {
        User finalUser = UserController.getFinalUser();
        Payment finalPayment = PaymentController.getFinalPayment();
        return service.proceedCreate(finalUser, finalPayment);
    }
}
