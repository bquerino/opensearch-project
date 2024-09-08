package com.brhenqu.payment.repository.dto;

import java.io.Serializable;

public record PaymentDto(Long id, String description, Double amount) implements Serializable {}
