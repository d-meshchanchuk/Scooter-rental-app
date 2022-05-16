package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.mapper.ScootersInfoMapper;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.repository.ScootersInfoRepository;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ScootersInfoServiceImpl implements ScootersInfoService {

    private final ScootersInfoRepository scootersInfoRepository;
    private final ScooterRepository scooterRepository;
    private final RentalPointRepository rentalPointRepository;
    private final ScootersInfoMapper scootersInfoMapper;

    @Override
    public ScootersInfoDto save(ScootersInfoDto scootersInfoDto) {
        ScootersInfo scootersInfo = scootersInfoMapper.toScootersInfo(scootersInfoDto);
        scootersInfoRepository.save(scootersInfo);
        log.info("IN save - tariffPrices: {} successfully created", scootersInfo);
        return scootersInfoDto;
    }

    @Override
    public void delete(Long id) {
        scootersInfoRepository.deleteById(id);
        log.info("IN delete - scootersInfo with id: {} successfully deleted", id);
    }

    @Override
    public ScootersInfoDto findById(Long id) throws NoContentException {
        Optional<ScootersInfo> scootersInfo = scootersInfoRepository.findById(id);

        if (scootersInfo.isEmpty()) {
            log.warn("IN findById - no scootersInfo found by id: {}", id);
            throw new NoContentException();
        }

        ScootersInfoDto result = scootersInfoMapper.fromScootersInfo(scootersInfo.get());

        log.info("IN findById - scootersInfo: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<ScootersInfoDto> findAll() {
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findAll();
        var result = scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findAll - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfoDto> findByScooterId(Long scooterId) {
        Scooter scooter = scooterRepository.getById(scooterId);
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findByScooter(scooter);
        var result = scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findByScooter - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfoDto> findByStatus(Status status) {
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findByStatus(status);
        var result = scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findByStatus - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfoDto> findByRentalPointId(Long rentalPointId) {
        RentalPoint rentalPoint = rentalPointRepository.getById(rentalPointId);
        List<ScootersInfo> scootersInfoList = scootersInfoRepository.findByRentalPoint(rentalPoint);
        var result = scootersInfoList.stream().map(scootersInfoMapper::fromScootersInfo).collect(Collectors.toList());
        log.info("IN findByRentalPoint - {} scootersInfo found", result.size());
        return result;
    }
}
