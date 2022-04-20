package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;

import java.util.List;

public interface ScooterService {

    ScooterDto save(ScooterDto scooterDto);

    void delete(Long id);

    List<ScooterDto> findAll();

    ScooterDto findById(Long id);
}
