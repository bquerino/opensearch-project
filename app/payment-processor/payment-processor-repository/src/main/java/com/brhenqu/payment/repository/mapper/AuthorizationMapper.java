package com.brhenqu.payment.repository.mapper;

import com.brhenqu.payment.domain.model.PaymentAuthorization;
import com.brhenqu.payment.repository.dto.AuthorizationDto;
import com.brhenqu.payment.repository.entity.AuthorizationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorizationMapper {

    AuthorizationDto toDTO(PaymentAuthorization entity);

    AuthorizationEntity toEntity(PaymentAuthorization authorization);

    @Mapping(target = "id", source = "id")
    PaymentAuthorization toDomain(AuthorizationEntity entity);
}
