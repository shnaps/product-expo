package me.shnaps.productexpo.service.impl;

import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.repository.PaymentRepository;
import me.shnaps.productexpo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements PaymentService {
    @Autowired
    @Qualifier("paymentRepository")
    private PaymentRepository repository;


    @Override
    public void save(Payment payment) {
        repository.save(payment);
    }
}
