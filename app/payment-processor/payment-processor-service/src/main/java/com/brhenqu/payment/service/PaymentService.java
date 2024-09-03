package com.brhenqu.payment.service;

import com.brhenqu.payment.repository.dto.PaymentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto paymentDto);
    List<PaymentDto> searchPaymentsByDescription(String description);
    Page<PaymentDto> searchPaymentByDescriptionPaginated(String description, Pageable pageable);
}
