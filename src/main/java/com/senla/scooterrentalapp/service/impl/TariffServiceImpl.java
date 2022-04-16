package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import com.senla.scooterrentalapp.repository.TariffRepository;
import com.senla.scooterrentalapp.service.TariffPricesService;
import com.senla.scooterrentalapp.service.TariffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    @Autowired
    public TariffServiceImpl(TariffRepository tariffRepository, TariffPricesService tariffPricesService) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public Tariff save(Tariff tariff) {
        tariffRepository.save(tariff);
        log.info("IN create - tariff: {} successfully created", tariff);
        return tariff;
    }

    @Override
    public void delete(Long id) {
        tariffRepository.deleteById(id);
        log.info("IN delete - tariff with id: {} successfully deleted", id);
    }

    @Override
    public List<Tariff> findAll() {
        List<Tariff> result = tariffRepository.findAll();
        log.info("IN findAll - {} tariffs found", result.size());
        return result;
    }

    @Override
    public Tariff findById(Long id) {
        Tariff result = tariffRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no tariff found by id: {}", id);
            return null;
        }

        log.info("IN findById - tariff: {} found by id: {}", result, id);
        return result;
    }
}
