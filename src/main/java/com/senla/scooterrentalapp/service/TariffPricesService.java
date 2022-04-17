package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.entity.tariff.TariffPrices;

import java.util.Date;
import java.util.List;

public interface TariffPricesService {

    TariffPrices save(TariffPrices tariffPrices);

    void delete(Long id);

    TariffPrices findById(Long id);

    List<TariffPrices> findAll();

    TariffPrices findCurrentTariff(Tariff tariff);
}
