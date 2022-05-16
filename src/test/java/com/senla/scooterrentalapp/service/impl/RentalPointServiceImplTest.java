package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.mapper.RentalPointMapper;
import com.senla.scooterrentalapp.mapper.RentalPointMapperImpl;
import com.senla.scooterrentalapp.mapper.ScooterMapper;
import com.senla.scooterrentalapp.mapper.ScooterMapperImpl;
import com.senla.scooterrentalapp.repository.OrderRepository;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.service.RentalPointService;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RentalPointServiceImplTest {

    RentalPointRepository repository = Mockito.mock(RentalPointRepository .class);
    RentalPointMapper rentalPointMapper = new RentalPointMapperImpl();
    RentalPointService service = new RentalPointServiceImpl(repository, rentalPointMapper);

    RentalPointParent rentalPointParent = RentalPointParent.builder()
            .id(1L)
            .name("Test")
            .build();

    RentalPoint rentalPoint = RentalPoint.builder()
            .id(1L)
            .parent(rentalPointParent)
            .build();

    List<RentalPoint> rentalPoints = new ArrayList<>();

    @Test
    void save() {
        RentalPointDto result = service.save(rentalPointMapper.fromRentalPoint(rentalPoint));
        Mockito.verify(repository).save(rentalPoint);
        assertEquals(rentalPointMapper.toRentalPoint(result), rentalPoint);
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(rentalPoints);
        List<RentalPointDto> rentalPointDtoList = service.findAll();
        Mockito.verify(repository, Mockito.times(1)).findAll();
        assertEquals(rentalPoints, rentalPointDtoList.stream().map(rentalPointMapper::toRentalPoint).collect(Collectors.toList()));
    }

    @Test
    @SneakyThrows
    void findById() {
        Long id = rentalPoint.getId();
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(rentalPoint));
        RentalPointDto result = service.findById(id);
        Mockito.verify(repository, Mockito.times(1)).findById(id);
        assertEquals(rentalPointMapper.toRentalPoint(result), rentalPoint);
    }
}