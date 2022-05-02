package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    OrderDto fromOrder(Order order);
}
