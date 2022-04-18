package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.user.User;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order update(Order order);

    void delete(Long id);

    Order findById(Long id);

    List<Order> findAll();

    List<Order> findByUser(User user);

}
