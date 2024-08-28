package com.brhenqu.payment.repository.dto;

public record AuthorizationDto(Long id, String authorizationNumber, Long paymentId) {}
