package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.exception.NoContentException;

import java.util.List;

public interface RentalPointService {

    RentalPointDto save(RentalPointDto rentalPointDto);

    void delete(Long id);

    List<RentalPointDto> findAll();

    RentalPointDto findById(Long id) throws NoContentException;
}
