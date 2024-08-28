package com.brhenqu.payment.service.impl;

import com.brhenqu.payment.domain.model.Payment;
import com.brhenqu.payment.repository.PaymentRepository;
import com.brhenqu.payment.repository.dto.PaymentDto;
import com.brhenqu.payment.service.PaymentService;
import com.brhenqu.payment.repository.mapper.PaymentMapper; // Assume que você tenha um mapper para conversão
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    @Transactional
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = paymentMapper.toDomain(paymentDto); // Converte o DTO para o modelo de domínio
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDto(savedPayment); // Converte o modelo de domínio salvo de volta para o DTO
    }

    @Override
    public List<PaymentDto> searchPaymentsByDescription(String description) {
        List<Payment> payments = paymentRepository.findByDescription(description);
        return payments.stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }
}
