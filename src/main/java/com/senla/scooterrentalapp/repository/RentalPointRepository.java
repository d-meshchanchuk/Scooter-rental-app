package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalPointRepository extends JpaRepository<RentalPoint, Long> {
}
