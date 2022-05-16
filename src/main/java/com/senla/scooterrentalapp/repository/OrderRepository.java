package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.Order;
import com.senla.scooterrentalapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);


}
