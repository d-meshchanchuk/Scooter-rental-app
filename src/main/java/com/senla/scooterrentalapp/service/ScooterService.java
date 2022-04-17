package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.scooter.Scooter;

import java.util.List;

public interface ScooterService {

    Scooter save(Scooter scooter);

    void delete(Long id);

    List<Scooter> findAll();

    Scooter findById(Long id);
}
