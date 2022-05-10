package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.mapper.TariffMapper;
import com.senla.scooterrentalapp.repository.TariffRepository;
import com.senla.scooterrentalapp.service.TariffService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TariffServiceImplTest {

//    TariffRepository repository = Mockito.mock(TariffRepository.class);
//    TariffService service = new TariffServiceImpl(repository);
//    TariffDto tariffDto = new TariffDto(1L, "test", 1, 1.0);
//    Tariff tariff = TariffMapper.TARIFF_MAPPER.toTariff(tariffDto);
//    List<Tariff> tariffs = new ArrayList<>();
//
//    @Test
//    void save() {
//        TariffDto tariff = service.save(tariffDto);
//        Mockito.verify(repository).save(TariffMapper.TARIFF_MAPPER.toTariff(tariffDto));
//        assertEquals(tariff, tariffDto);
//    }
//
//    @Test
//    void findAll() {
//        Mockito.when(repository.findAll()).thenReturn(tariffs);
//        List<TariffDto> tariffDtoList = service.findAll();
//        Mockito.verify(repository, Mockito.times(1)).findAll();
//        assertEquals(tariffs, tariffDtoList.stream().map(TariffMapper.TARIFF_MAPPER::toTariff).collect(Collectors.toList()));
//    }
//
//    @Test
//    void findById() {
//        Long id = tariff.getId();
//        Mockito.when(repository.findById(id)).thenReturn(Optional.of(tariff));
//        TariffDto result = service.findById(id);
//        Mockito.verify(repository, Mockito.times(1)).findById(id);
//        assertEquals(tariffDto, result);
//    }
}