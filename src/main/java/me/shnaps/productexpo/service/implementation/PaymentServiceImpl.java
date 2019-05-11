package me.shnaps.productexpo.service.implementation;

import me.shnaps.productexpo.entity.Payment;
import me.shnaps.productexpo.repository.PaymentRepository;
import me.shnaps.productexpo.service.PaymentService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment save(@NonNull Payment payment) {
        repository.save(payment);
        return payment;
    }
}
