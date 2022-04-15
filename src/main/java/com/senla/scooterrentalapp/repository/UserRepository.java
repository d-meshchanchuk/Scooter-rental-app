package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
