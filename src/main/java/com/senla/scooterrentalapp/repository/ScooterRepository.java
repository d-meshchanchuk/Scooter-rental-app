package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.scooter.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
