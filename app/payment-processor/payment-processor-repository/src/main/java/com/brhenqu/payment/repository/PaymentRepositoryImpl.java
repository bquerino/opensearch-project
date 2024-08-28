package com.brhenqu.payment.repository;

import com.brhenqu.payment.domain.model.Payment;
import com.brhenqu.payment.repository.entity.PaymentEntity;
import com.brhenqu.payment.repository.mapper.PaymentMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final PaymentMapper paymentMapper;

    public PaymentRepositoryImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    @Transactional
    public Payment save(Payment payment) {
        PaymentEntity entity = paymentMapper.toEntity(payment);
        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }
        return paymentMapper.toDomain(entity);
    }

    @Override
    public List<Payment> findByDescription(String description) {
        List<PaymentEntity> entities = Search.session(entityManager)
                .search(PaymentEntity.class)
                .where(f -> f.match().field("description").matching(description))
                .fetchHits(20);
        return entities.stream()
                .map(paymentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
