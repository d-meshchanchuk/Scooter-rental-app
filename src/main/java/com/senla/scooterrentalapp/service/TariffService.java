package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.tariff.Tariff;

import java.util.List;

public interface TariffService {

    Tariff create(Tariff tariff);

    Tariff update(Tariff tariff);

    Tariff delete(Long id);

    List<Tariff> findAll();

    Tariff findById(Long id);
}
