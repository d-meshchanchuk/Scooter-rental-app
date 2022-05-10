package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto fromOrder(Order order);

    Order toOrder(OrderDto orderDto);
}
