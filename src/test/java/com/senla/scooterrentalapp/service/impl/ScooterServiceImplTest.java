package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.mapper.ScooterMapper;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.service.ScooterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScooterServiceImplTest {

    ScooterRepository repository = Mockito.mock(ScooterRepository.class);
    ScooterService service = new ScooterServiceImpl(repository);
    ScooterDto scooterDto = new ScooterDto(1L, "test", 100);
    Scooter scooter = ScooterMapper.SCOOTER_MAPPER.toScooter(scooterDto);
    List<Scooter> scooters = new ArrayList<>();

    @Test
    void save() {
        ScooterDto result = service.save(scooterDto);
        Mockito.verify(repository).save(ScooterMapper.SCOOTER_MAPPER.toScooter(scooterDto));
        assertEquals(result, scooterDto);
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(scooters);
        List<ScooterDto> scooterDtoList = service.findAll();
        Mockito.verify(repository, Mockito.times(1)).findAll();
        assertEquals(scooters, scooterDtoList.stream().map(ScooterMapper.SCOOTER_MAPPER::toScooter).collect(Collectors.toList()));
    }

    @Test
    void findById() {
        Long id = scooter.getId();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(scooter));
        ScooterDto result = service.findById(id);
        Mockito.verify(repository, Mockito.times(1)).findById(id);
        assertEquals(scooterDto, result);
    }
}