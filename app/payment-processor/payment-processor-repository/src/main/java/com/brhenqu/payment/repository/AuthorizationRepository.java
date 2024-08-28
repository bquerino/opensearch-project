package com.brhenqu.payment.repository;

import com.brhenqu.payment.domain.model.PaymentAuthorization;
import java.util.List;

public interface AuthorizationRepository {
    PaymentAuthorization save(PaymentAuthorization authorization);
    List<PaymentAuthorization> findByAuthorizationNumber(String authorizationNumber);
}
