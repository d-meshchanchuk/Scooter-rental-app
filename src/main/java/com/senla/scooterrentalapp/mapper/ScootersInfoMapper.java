package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScootersInfoMapper {

    ScootersInfoDto fromScootersInfo(ScootersInfo scootersInfo);

    ScootersInfo toScootersInfo(ScootersInfoDto scootersInfoDto);
}
