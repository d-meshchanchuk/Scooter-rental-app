package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import com.senla.scooterrentalapp.mapper.ScootersInfoMapper;
import com.senla.scooterrentalapp.mapper.ScootersInfoMapperImpl;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.repository.ScootersInfoRepository;
import com.senla.scooterrentalapp.service.ScootersInfoService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;


class ScootersInfoServiceImplTest {

    ScootersInfoRepository scootersInfoRepository = Mockito.mock(ScootersInfoRepository.class);
    ScooterRepository scooterRepository = Mockito.mock(ScooterRepository.class);;
    RentalPointRepository rentalPointRepository = Mockito.mock(RentalPointRepository.class);;
    ScootersInfoMapper scootersInfoMapper = new ScootersInfoMapperImpl();
    ScootersInfoService service = new ScootersInfoServiceImpl(scootersInfoRepository, scooterRepository, rentalPointRepository, scootersInfoMapper);

    Scooter scooter = Scooter.builder()
            .id(1L)
            .model("test")
            .power(100)
            .build();

    ScootersInfo scootersInfo = ScootersInfo.builder()
            .id(1L)
            .scooter(scooter)
            .status(Status.ACTIVE)
            .build();

    ScootersInfoDto scootersInfoDto = scootersInfoMapper.fromScootersInfo(scootersInfo);

    List<ScootersInfo> scootersInfoList = new ArrayList<>();


    @Test
    void save() {
        Mockito.when(scooterRepository.getById(1L)).thenReturn(scooter);
        ScootersInfoDto result = service.save(scootersInfoDto);
        Mockito.verify(scootersInfoRepository).save(scootersInfo);
        assertEquals(result, scootersInfoDto);
    }

    @Test
    void findAll() {
        Mockito.when(scootersInfoRepository.findAll()).thenReturn(scootersInfoList);
        List<ScootersInfoDto> scootersInfoDtoList = service.findAll();
        Mockito.verify(scootersInfoRepository, Mockito.times(1)).findAll();
        assertEquals(scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList()), scootersInfoDtoList);
    }

    @SneakyThrows
    @Test
    void findById() {
        Long id = scootersInfo.getId();
        Mockito.when(scootersInfoRepository.findById(id)).thenReturn(Optional.ofNullable(scootersInfo));
        ScootersInfoDto result = service.findById(id);
        Mockito.verify(scootersInfoRepository, Mockito.times(1)).findById(id);
        assertEquals(scootersInfoDto, result);
    }

    @Test
    void findByScooter() {
        Long id = scooter.getId();
        scootersInfoList.add(scootersInfo);
        Mockito.when(scootersInfoRepository.findByScooter(scooter)).thenReturn(scootersInfoList);
        Mockito.when(scooterRepository.getById(id)).thenReturn(scooter);
        List<ScootersInfoDto> result = service.findByScooterId(scooter.getId());
        Mockito.verify(scootersInfoRepository, Mockito.times(1)).findByScooter(scooter);
        assertEquals(scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList()), result);
    }

    @Test
    void findByStatus() {
        scootersInfoList.add(scootersInfo);
        Mockito.when(scootersInfoRepository.findByStatus(Status.ACTIVE)).thenReturn(scootersInfoList);
        List<ScootersInfoDto> result = service.findByStatus(Status.ACTIVE);
        Mockito.verify(scootersInfoRepository, Mockito.times(1)).findByStatus(Status.ACTIVE);
        assertEquals(scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList()), result);
    }
}