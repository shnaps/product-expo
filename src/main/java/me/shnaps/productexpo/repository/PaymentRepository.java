package me.shnaps.productexpo.repository;

import me.shnaps.productexpo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment getPaymentByCardNumber(String cardNumber);
}
