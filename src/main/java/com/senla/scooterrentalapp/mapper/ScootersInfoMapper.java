package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScootersInfoMapper {
    ScootersInfoMapper SCOOTERS_INFO_MAPPER = Mappers.getMapper(ScootersInfoMapper.class);

    ScootersInfoDto fromScootersInfo(ScootersInfo scootersInfo);

    @InheritInverseConfiguration
    ScootersInfo toScootersInfo(ScootersInfoDto scootersInfoDto);
}
