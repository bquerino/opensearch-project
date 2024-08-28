package com.brhenqu.payment.service;

import com.brhenqu.payment.domain.model.PaymentAuthorization;
import com.brhenqu.payment.repository.dto.AuthorizationDto;

import java.util.List;

public interface AuthorizationService {

    AuthorizationDto createAuthorization(PaymentAuthorization authorization);

    List<AuthorizationDto> searchAuthorizationsByNumber(String authorizationNumber);
}
