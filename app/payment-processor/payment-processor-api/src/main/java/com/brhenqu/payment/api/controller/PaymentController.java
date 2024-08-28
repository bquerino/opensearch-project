package com.brhenqu.payment.api.controller;

import com.brhenqu.payment.repository.dto.PaymentDto;
import com.brhenqu.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok(paymentService.createPayment(paymentDto));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PaymentDto>> searchByDescription(@RequestParam String description) {
        return ResponseEntity.ok(paymentService.searchPaymentsByDescription(description));
    }
}
