package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;

import java.util.List;

public interface ScootersInfoService {

    ScootersInfo save(ScootersInfo scootersInfo);

    void delete(Long id);

    ScootersInfo findById(Long id);

    List<ScootersInfo> findAll();

    List<ScootersInfo> findByScooter(Scooter scooter);

    List<ScootersInfo> findByStatus(Status status);

    List<ScootersInfo> findByRentalPoint(RentalPoint rentalPoint);

}
