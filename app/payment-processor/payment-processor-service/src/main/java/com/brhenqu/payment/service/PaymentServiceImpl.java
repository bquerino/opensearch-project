package com.brhenqu.payment.service;

import com.brhenqu.payment.domain.model.Payment;
import com.brhenqu.payment.repository.PaymentRepository;
import com.brhenqu.payment.repository.dto.PaymentDto;
import com.brhenqu.payment.service.PaymentService;
import com.brhenqu.payment.repository.mapper.PaymentMapper; // Assume que você tenha um mapper para conversão
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Payment payment = paymentMapper.toDomain(paymentDto);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDto(savedPayment);
    }

    @Override
    @Cacheable(value = "payments", key = "#description")
    public List<PaymentDto> searchPaymentsByDescription(String description) {
        List<Payment> payments = paymentRepository.findByDescription(description);
        return payments.stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<PaymentDto> searchPaymentByDescriptionPaginated(String description, Pageable pageable) {
        return paymentRepository.findByDescriptionPaginated(description, pageable)
                .map(paymentMapper::toDto);
    }
}
