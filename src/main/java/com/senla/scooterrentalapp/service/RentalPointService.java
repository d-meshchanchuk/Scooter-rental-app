package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;

import java.util.List;

public interface RentalPointService {

    RentalPoint save(RentalPoint rentalPoint);

    void delete(Long id);

    List<RentalPoint> findAll();

    RentalPoint findById(Long id);
}
