package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScooterMapper {

    ScooterDto fromScooter(Scooter scooter);

    Scooter toScooter(ScooterDto scooterDto);
}
