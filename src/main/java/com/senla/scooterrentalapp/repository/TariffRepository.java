package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
