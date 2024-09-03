package com.brhenqu.payment.repository;

import com.brhenqu.payment.domain.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentRepository {
    Payment save(Payment payment);
    List<Payment> findByDescription(String description);
    Page<Payment> findByDescriptionPaginated(String description, Pageable pageable);
}
