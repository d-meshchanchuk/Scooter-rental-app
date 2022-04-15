package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.tariff.TariffPrices;

import java.util.Date;
import java.util.List;

public interface TariffPricesService {

    TariffPrices create(TariffPrices tariffPrices);

    TariffPrices update(TariffPrices tariffPrices);

    TariffPrices delete(Long id);

    List<TariffPrices> findAll();

    TariffPrices findByDate(Long id, Date date);
}
