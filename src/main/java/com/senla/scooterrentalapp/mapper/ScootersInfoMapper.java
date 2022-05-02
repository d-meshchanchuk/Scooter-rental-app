package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScootersInfoMapper {
    ScootersInfoMapper SCOOTERS_INFO_MAPPER = Mappers.getMapper(ScootersInfoMapper.class);

    @Mappings({
            @Mapping(source = "rentalPoint.id", target = "rentalPointId"),
            @Mapping(source = "scooter.id", target = "scooterId"),
    })
    ScootersInfoDto fromScootersInfo(ScootersInfo scootersInfo);
}
