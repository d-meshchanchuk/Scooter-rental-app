package com.senla.scooterrentalapp.mapper;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TariffMapper {

    TariffDto fromTariff(Tariff tariff);

    Tariff toTariff(TariffDto tariffDto);
}

