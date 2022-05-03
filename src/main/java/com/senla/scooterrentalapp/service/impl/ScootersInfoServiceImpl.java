package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import com.senla.scooterrentalapp.mapper.ScooterMapper;
import com.senla.scooterrentalapp.mapper.ScootersInfoMapper;
import com.senla.scooterrentalapp.repository.RentalPointParentRepository;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.repository.ScootersInfoRepository;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ScootersInfoServiceImpl implements ScootersInfoService {

    private final ScootersInfoRepository scootersInfoRepository;
    private final ScooterRepository scooterRepository;
    private final RentalPointRepository rentalPointRepository;
    private final RentalPointParentRepository rentalPointParentRepository;

    @Override
    public ScootersInfoDto save(ScootersInfoDto scootersInfoDto) {
        ScootersInfo scootersInfo = ScootersInfo.builder()
                .id(scootersInfoDto.getId())
                .scooter(scooterRepository.getById(scootersInfoDto.getScooterId()))
                .engineHours(scootersInfoDto.getEngineHours())
                .rentalPoint(rentalPointRepository.getById(scootersInfoDto.getRentalPointId()))
                .status(scootersInfoDto.getStatus()).build();
        log.info("IN save - tariffPrices: {} successfully created", scootersInfo);
        scootersInfoRepository.save(scootersInfo);
        return scootersInfoDto;
    }

    @Override
    public void delete(Long id) {
        scootersInfoRepository.deleteById(id);
        log.info("IN delete - scootersInfo with id: {} successfully deleted", id);
    }

    @Override
    public ScootersInfoDto findById(Long id) {
        ScootersInfo scootersInfo = scootersInfoRepository.findById(id).orElse(null);

        if (scootersInfo == null) {
            log.warn("IN findById - no scootersInfo found by id: {}", id);
            return null;
        }

        ScootersInfoDto result = ScootersInfoMapper.SCOOTERS_INFO_MAPPER.fromScootersInfo(scootersInfo);

        log.info("IN findById - scootersInfo: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<ScootersInfoDto> findAll() {
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findAll();
        var result = scootersInfoList.stream().map(ScootersInfoMapper.SCOOTERS_INFO_MAPPER::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findAll - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfoDto> findByScooter(ScooterDto scooterDto) {
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findByScooter(ScooterMapper.SCOOTER_MAPPER.toScooter(scooterDto));
        var result = scootersInfoList.stream().map(ScootersInfoMapper.SCOOTERS_INFO_MAPPER::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findByScooter - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfoDto> findByStatus(Status status) {
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findByStatus(status);
        var result = scootersInfoList.stream().map(ScootersInfoMapper.SCOOTERS_INFO_MAPPER::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findByStatus - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfoDto> findByRentalPoint(RentalPointDto rentalPointDto) {
        RentalPoint rentalPoint = RentalPoint.builder()
                .id(rentalPointDto.getId())
                .parent(rentalPointParentRepository.getById(rentalPointDto.getId()))
                .location(rentalPointDto.getLocation())
                .latitude(rentalPointDto.getLatitude())
                .longitude(rentalPointDto.getLongitude())
                .build();
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findByRentalPoint(rentalPoint);
        var result = scootersInfoList.stream().map(ScootersInfoMapper.SCOOTERS_INFO_MAPPER::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findByRentalPoint - {} scootersInfo found", result.size());
        return result;
    }
}
