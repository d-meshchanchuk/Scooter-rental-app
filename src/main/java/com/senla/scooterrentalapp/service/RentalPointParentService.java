package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;

import java.util.List;

public interface RentalPointParentService {

    RentalPointParent save(RentalPointParent rentalPointParent);

    void delete(Long id);

    List<RentalPointParent> findAll();

    RentalPointParent findById(Long id);
}
