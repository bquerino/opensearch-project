package com.brhenqu.payment.repository;

import com.brhenqu.payment.domain.model.PaymentAuthorization;
import com.brhenqu.payment.repository.entity.AuthorizationEntity;
import com.brhenqu.payment.repository.mapper.AuthorizationMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final AuthorizationMapper authorizationMapper;

    public AuthorizationRepositoryImpl(AuthorizationMapper authorizationMapper) {
        this.authorizationMapper = authorizationMapper;
    }

    @Override
    public PaymentAuthorization save(PaymentAuthorization authorization) {
        AuthorizationEntity entity = authorizationMapper.toEntity(authorization);
        entityManager.persist(entity);
        return authorizationMapper.toDomain(entity);
    }

    @Override
    public List<PaymentAuthorization> findByAuthorizationNumber(String authorizationNumber) {
        List<AuthorizationEntity> entities = Search.session(entityManager)
                .search(AuthorizationEntity.class)
                .where(f -> f.match().field("authorizationNumber").matching(authorizationNumber))
                .fetchHits(20);
        return entities.stream()
                .map(authorizationMapper::toDomain)
                .collect(Collectors.toList());
    }
}
