package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto fromOrder(Order order);

    Order toOrder(OrderDto orderDto);
}
