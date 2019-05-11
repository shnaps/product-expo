package me.shnaps.productexpo.service.implementation;

import me.shnaps.productexpo.dto.PaymentDto;
import me.shnaps.productexpo.dto.ResultDto;
import me.shnaps.productexpo.dto.UserDto;
import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.service.OrchestrationService;
import me.shnaps.productexpo.service.PaymentService;
import me.shnaps.productexpo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrchestrationServiceImpl implements OrchestrationService {
    private final PaymentService paymentService;
    private final UserService userService;

    public OrchestrationServiceImpl(PaymentService paymentService, UserService userService) {
        this.paymentService = paymentService;
        this.userService = userService;
    }

    @Override
    public ResultDto proceedCreate(User finalUser, Payment finalPayment) {
        Payment savedPayment = paymentService.save(finalPayment);
        User savedUser = userService.save(finalUser);
        PaymentDto paymentDto = savedPayment.transformToDto();
        UserDto userDto = savedUser.transformToDto();
        return new ResultDto(paymentDto, userDto);
    }
}
