package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.OrderDto;
import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.exception.NoContentException;

import java.util.List;

public interface OrderService {

    OrderDto save(OrderDto orderDto);

    void calculatePrice(Order order);

    void delete(Long id);

    OrderDto findById(Long id) throws NoContentException;

    List<OrderDto> findAll();

    List<OrderDto> findByUserId(Long id);

}
