package com.brhenqu.payment.api.controller;

import com.brhenqu.payment.repository.dto.PaymentDto;
import com.brhenqu.payment.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/search-paginated")
    public ResponseEntity<Page<PaymentDto>> searchByDescriptionPaginated(@RequestParam String description,
                                                                         Pageable pageable){
        return ResponseEntity.ok(paymentService.searchPaymentByDescriptionPaginated(description, pageable));
    }
}
