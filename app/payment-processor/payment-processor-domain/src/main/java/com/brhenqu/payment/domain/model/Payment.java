package com.brhenqu.payment.domain.model;

public class Payment {

    private Long id;
    private String description;
    private final Double amount;

    public Payment(String description, Double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Rich domain methods
    public void updateDescription(String newDescription) {
        if (newDescription == null || newDescription.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }
        this.description = newDescription;
    }

    // Getters and business logic
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
