package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);


}
