package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointParentDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalPointParentMapper {
    RentalPointParentMapper SCOOTER_MAPPER = Mappers.getMapper(RentalPointParentMapper.class);

    RentalPointParentDto fromRentalPointParent(RentalPointParent rentalPointParent);

    @InheritInverseConfiguration
    RentalPointParent toRentalPointParent(RentalPointParentDto rentalPointParentDto);
}
