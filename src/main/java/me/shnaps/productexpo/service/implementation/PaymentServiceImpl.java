package me.shnaps.productexpo.service.implementation;

import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.repository.PaymentRepository;
import me.shnaps.productexpo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment save(Payment payment) {
        repository.save(payment);
        return payment;
    }
}
