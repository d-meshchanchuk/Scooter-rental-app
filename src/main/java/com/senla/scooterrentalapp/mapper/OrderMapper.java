package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(source = "tariff.id", target = "tariffId"),
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "scooter.id", target = "scooterId"),
            @Mapping(source = "startPoint.id", target = "startPointId"),
            @Mapping(source = "finishPoint.id", target = "finishPointId")
    })
    OrderDto fromOrder(Order order);
}
