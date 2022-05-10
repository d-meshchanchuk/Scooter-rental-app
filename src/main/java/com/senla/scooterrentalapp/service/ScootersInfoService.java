package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.exception.NoContentException;

import java.util.List;

public interface ScootersInfoService {

    ScootersInfoDto save(ScootersInfoDto scootersInfo);

    void delete(Long id);

    ScootersInfoDto findById(Long id) throws NoContentException;

    List<ScootersInfoDto> findAll();

    List<ScootersInfoDto> findByScooterId(Long id);

    List<ScootersInfoDto> findByStatus(Status status);

    List<ScootersInfoDto> findByRentalPointId(Long id);

}
