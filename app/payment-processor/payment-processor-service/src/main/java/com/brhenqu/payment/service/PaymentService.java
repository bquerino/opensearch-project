package com.brhenqu.payment.service;

import com.brhenqu.payment.repository.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto paymentDto);
    List<PaymentDto> searchPaymentsByDescription(String description);
}
