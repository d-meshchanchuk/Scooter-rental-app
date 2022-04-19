package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalPointParentRepository extends JpaRepository<RentalPointParent, Long> {
}
