package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScootersInfoRepository extends JpaRepository<ScootersInfo, Long> {

    List<ScootersInfo> findByScooter(Scooter scooter);

    List<ScootersInfo> findByStatus(Status status);

    List<ScootersInfo> findByRentalPoint(RentalPoint rentalPoint);
}
