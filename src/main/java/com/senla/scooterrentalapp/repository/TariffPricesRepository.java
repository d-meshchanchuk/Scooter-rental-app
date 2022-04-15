package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import com.senla.scooterrentalapp.service.TariffPricesService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TariffPricesRepository extends JpaRepository<TariffPrices, Long> {

    TariffPricesService findByDate(Long id, Date date);
}
