package com.brhenqu.payment.repository;

import com.brhenqu.payment.domain.model.Payment;
import java.util.List;

public interface PaymentRepository {
    Payment save(Payment payment);
    List<Payment> findByDescription(String description);
}
