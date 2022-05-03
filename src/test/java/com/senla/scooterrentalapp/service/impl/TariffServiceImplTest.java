package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.repository.TariffRepository;
import com.senla.scooterrentalapp.service.TariffService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TariffServiceImplTest {

    TariffRepository repository = Mockito.mock(TariffRepository.class);
    TariffService service = new TariffServiceImpl(repository);
    TariffDto tariff = new TariffDto();

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }
}