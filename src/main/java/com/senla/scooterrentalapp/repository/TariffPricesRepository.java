package com.senla.scooterrentalapp.repository;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffPricesRepository extends JpaRepository<TariffPrices, Long> {

    TariffPrices findFirstByTariffOrderByIdDesc(Tariff tariff);

}
