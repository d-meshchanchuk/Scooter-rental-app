package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalPointMapper {

    RentalPointDto fromRentalPoint(RentalPoint rentalPoint);

    RentalPoint toRentalPoint(RentalPointDto rentalPointDto);
}

