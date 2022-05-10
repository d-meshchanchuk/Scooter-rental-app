package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointParentDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalPointParentMapper {

    RentalPointParentDto fromRentalPointParent(RentalPointParent rentalPointParent);

    RentalPointParent toRentalPointParent(RentalPointParentDto rentalPointParentDto);
}
