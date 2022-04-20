package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.dto.user.UserDto;
import com.senla.scooterrentalapp.entity.Order;

import java.util.List;

public interface OrderService {

    OrderDto save(OrderDto orderDto);

    void calculatePrice(Order order);

    void calculateDiscount(Order order);

    void delete(Long id);

    OrderDto findById(Long id);

    List<OrderDto> findAll();

    List<OrderDto> findByUser(UserDto userDto);

}
