package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
