package me.shnaps.productexpo.service;

import me.shnaps.productexpo.dto.ResultDto;
import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.entity.User;

public interface OrchestrationService {
    ResultDto proceedCreate(User finalUser, Payment finalPayment);


}
