package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointParentDto;
import com.senla.scooterrentalapp.exception.NoContentException;

import java.util.List;

public interface RentalPointParentService {

    RentalPointParentDto save(RentalPointParentDto rentalPointParentDto);

    void delete(Long id);

    List<RentalPointParentDto> findAll();

    RentalPointParentDto findById(Long id) throws NoContentException;
}
