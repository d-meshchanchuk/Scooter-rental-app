package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import com.senla.scooterrentalapp.repository.TariffPricesRepository;
import com.senla.scooterrentalapp.service.TariffPricesService;
import com.senla.scooterrentalapp.service.TariffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TariffPricesServiceImpl implements TariffPricesService {
    private final TariffPricesRepository tariffPricesRepository;

    @Autowired
    public TariffPricesServiceImpl(TariffPricesRepository tariffPricesRepository) {
        this.tariffPricesRepository = tariffPricesRepository;
    }

    @Override
    public TariffPrices save(TariffPrices tariffPrices) {
        log.info("IN create - tariffPrices: {} successfully created", tariffPrices);
        return tariffPricesRepository.save(tariffPrices);
    }

    @Override
    public void delete(Long id) {
        tariffPricesRepository.deleteById(id);
        log.info("IN delete - tariffPrices with id: {} successfully deleted", id);
    }

    public TariffPrices findById(Long id) {
        TariffPrices result = tariffPricesRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no tariffPrices found by id: {}", id);
            return null;
        }

        log.info("IN findById - tariffPrices: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<TariffPrices> findAll() {
        List<TariffPrices> result = tariffPricesRepository.findAll();
        log.info("IN findAll - {} tariffPrices found", result.size());
        return result;
    }

    @Override
    public TariffPrices findByDate(Tariff tariff) {
        return tariffPricesRepository.findFirstByTariffOrderByIdDesc(tariff);
    }
}
