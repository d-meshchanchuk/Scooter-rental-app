package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import com.senla.scooterrentalapp.repository.ScootersInfoRepository;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ScootersInfoServiceImpl implements ScootersInfoService {

    private final ScootersInfoRepository scootersInfoRepository;

    @Autowired
    public ScootersInfoServiceImpl(ScootersInfoRepository scootersInfoRepository) {
        this.scootersInfoRepository = scootersInfoRepository;
    }

    @Override
    public ScootersInfo save(ScootersInfo scootersInfo) {
        log.info("IN save - tariffPrices: {} successfully created", scootersInfo);
        return scootersInfoRepository.save(scootersInfo);
    }

    @Override
    public void delete(Long id) {
        scootersInfoRepository.deleteById(id);
        log.info("IN delete - scootersInfo with id: {} successfully deleted", id);
    }

    @Override
    public ScootersInfo findById(Long id) {
        ScootersInfo result = scootersInfoRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no scootersInfo found by id: {}", id);
            return null;
        }

        log.info("IN findById - scootersInfo: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public List<ScootersInfo> findAll() {
        List<ScootersInfo> result = scootersInfoRepository.findAll();
        log.info("IN findAll - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfo> findByScooter(Scooter scooter) {
        List<ScootersInfo> result = scootersInfoRepository.findByScooter(scooter);
        log.info("IN findByScooter - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfo> findByStatus(Status status) {
        List<ScootersInfo> result = scootersInfoRepository.findByStatus(status);
        log.info("IN findByStatus - {} scootersInfo found", result.size());
        return result;
    }

    @Override
    public List<ScootersInfo> findByRentalPoint(RentalPoint rentalPoint) {
        List<ScootersInfo> result = scootersInfoRepository.findByRentalPoint(rentalPoint);
        log.info("IN findByRentalPoint - {} scootersInfo found", result.size());
        return result;
    }
}
