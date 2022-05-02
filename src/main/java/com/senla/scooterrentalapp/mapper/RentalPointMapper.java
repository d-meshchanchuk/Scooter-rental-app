package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalPointMapper {
    RentalPointMapper RENTAL_POINT_MAPPER = Mappers.getMapper(RentalPointMapper.class);

    @Mapping(source = "parent.id", target = "parentId")
    RentalPointDto fromRentalPoint(RentalPoint rentalPoint);
}

