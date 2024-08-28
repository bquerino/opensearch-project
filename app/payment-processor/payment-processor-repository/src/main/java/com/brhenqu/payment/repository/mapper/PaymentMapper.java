package com.brhenqu.payment.repository.mapper;

import com.brhenqu.payment.domain.model.Payment;
import com.brhenqu.payment.repository.dto.PaymentDto;
import com.brhenqu.payment.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    // Mapeia Payment (domain model) para PaymentEntity (entity)
    PaymentEntity toEntity(Payment payment);

    // Mapeia PaymentEntity (entity) para Payment (domain model)
    Payment toDomain(PaymentEntity paymentEntity);

    // Mapeia PaymentDto para Payment (domain model)
    Payment toDomain(PaymentDto paymentDto);

    // Mapeia Payment (domain model) para PaymentDto
    PaymentDto toDto(Payment payment);
}
