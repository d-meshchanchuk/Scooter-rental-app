package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;

import java.util.List;

public interface TariffService {

    TariffDto save(TariffDto tariff);

    void delete(Long id);

    List<TariffDto> findAll();

    TariffDto findById(Long id);
}
