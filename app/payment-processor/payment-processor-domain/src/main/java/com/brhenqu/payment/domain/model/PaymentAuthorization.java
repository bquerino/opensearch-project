package com.brhenqu.payment.domain.model;

public class PaymentAuthorization {

    private Long id;
    private final String authorizationNumber;
    private final Long paymentId;

    public PaymentAuthorization(String authorizationNumber, Long paymentId) {
        this.authorizationNumber = authorizationNumber;
        this.paymentId = paymentId;
    }

    // Rich domain methods
    public boolean isValid() {
        return authorizationNumber != null && !authorizationNumber.isEmpty();
    }

    // Getters and business logic
    public Long getId() {
        return id;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

