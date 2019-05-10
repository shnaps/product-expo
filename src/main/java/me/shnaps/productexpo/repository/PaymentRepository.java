package me.shnaps.productexpo.repository;

import me.shnaps.productexpo.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("paymentRepository")
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
    Payment getPaymentByCardNumber(String cardNumber);
}
