package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;

import java.util.List;

public interface ScootersInfoService {

    ScootersInfoDto save(ScootersInfoDto scootersInfo);

    void delete(Long id);

    ScootersInfoDto findById(Long id);

    List<ScootersInfoDto> findAll();

    List<ScootersInfoDto> findByScooter(ScooterDto scooterDto);

    List<ScootersInfoDto> findByStatus(Status status);

    List<ScootersInfoDto> findByRentalPoint(RentalPointDto rentalPointDto);

}
