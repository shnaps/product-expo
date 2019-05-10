package me.shnaps.productexpo.entity.payment;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
    Payment getPaymentByCardNumber(String cardNumber);
}
