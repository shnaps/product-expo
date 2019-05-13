package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.ResultDto;
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
        return service.proceedCreate(UserController.finalUser, PaymentController.finalPayment);
    }
}
