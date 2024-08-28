package com.brhenqu.payment.service;

import com.brhenqu.payment.domain.model.PaymentAuthorization;
import com.brhenqu.payment.repository.AuthorizationRepository;
import com.brhenqu.payment.repository.dto.AuthorizationDto;
import com.brhenqu.payment.repository.mapper.AuthorizationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final AuthorizationRepository authorizationRepository;
    private final AuthorizationMapper authorizationMapper;

    public AuthorizationServiceImpl(AuthorizationRepository authorizationRepository, AuthorizationMapper authorizationMapper) {
        this.authorizationRepository = authorizationRepository;
        this.authorizationMapper = authorizationMapper;
    }

    @Override
    public AuthorizationDto createAuthorization(PaymentAuthorization authorization) {
        PaymentAuthorization savedAuthorization = authorizationRepository.save(authorization);
        return authorizationMapper.toDTO(savedAuthorization);
    }

    @Override
    public List<AuthorizationDto> searchAuthorizationsByNumber(String authorizationNumber) {
        List<PaymentAuthorization> authorizations = authorizationRepository.findByAuthorizationNumber(authorizationNumber);
        return authorizations.stream()
                .map(authorizationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
