package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TariffMapper {
    TariffMapper TARIFF_MAPPER = Mappers.getMapper(TariffMapper.class);

    TariffDto fromTariff(Tariff tariff);

    @InheritInverseConfiguration
    Tariff toTariff(TariffDto tariffDto);
}

