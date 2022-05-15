package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.mapper.TariffMapper;
import com.senla.scooterrentalapp.mapper.TariffMapperImpl;
import com.senla.scooterrentalapp.repository.TariffRepository;
import com.senla.scooterrentalapp.service.TariffService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TariffServiceImplTest {

    @MockBean
    TariffRepository repository;

    TariffMapper tariffMapper = new TariffMapperImpl();

    @Autowired
    TariffService service;

    List<Tariff> tariffs = new ArrayList<>();

    @Test
    void save() {
        Tariff tariff = new Tariff();
        tariff.setId(1L);
        tariff.setName("test");
        tariff.setHours(1);
        tariff.setPricePerHour(1.5);
        TariffDto tariffDto = service.save(tariffMapper.fromTariff(tariff));
        System.out.println(tariff);
        Mockito.verify(repository).save(tariffMapper.toTariff(tariffDto));
        assertEquals(tariffMapper.fromTariff(tariff), tariffDto);
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(tariffs);
        List<TariffDto> tariffDtoList = service.findAll();
        Mockito.verify(repository, Mockito.times(1)).findAll();
        assertEquals(tariffs, tariffDtoList.stream().map(tariffMapper::toTariff).collect(Collectors.toList()));
    }

    @Test
    void findById() throws NoContentException {
        Tariff tariff = new Tariff();
        tariff.setId(1L);
        tariff.setName("test");
        tariff.setHours(1);
        tariff.setPricePerHour(1.5);
        Long id = tariff.getId();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(tariff));
        TariffDto result = service.findById(id);
        Mockito.verify(repository, Mockito.times(1)).findById(id);
        assertEquals(tariffMapper.fromTariff(tariff), result);
    }
}