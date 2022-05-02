package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScooterMapper {
    ScooterMapper SCOOTER_MAPPER = Mappers.getMapper(ScooterMapper.class);

    ScooterDto fromScooter(Scooter scooter);

    @InheritInverseConfiguration
    Scooter toScooter(ScooterDto scooterDto);
}
