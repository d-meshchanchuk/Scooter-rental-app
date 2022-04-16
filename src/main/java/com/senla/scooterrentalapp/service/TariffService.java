package com.senla.scooterrentalapp.service;

import com.senla.scooterrentalapp.entity.tariff.Tariff;

import java.util.List;

public interface TariffService {

    Tariff save(Tariff tariff);

    void delete(Long id);

    List<Tariff> findAll();

    Tariff findById(Long id);
}
