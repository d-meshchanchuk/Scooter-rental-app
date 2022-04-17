package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.service.RentalPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RentalPointServiceImpl implements RentalPointService {

    private final RentalPointRepository rentalPointRepository;

    @Autowired
    public RentalPointServiceImpl(RentalPointRepository rentalPointRepository) {
        this.rentalPointRepository = rentalPointRepository;
    }

    @Override
    public RentalPoint save(RentalPoint rentalPoint) {
        rentalPointRepository.save(rentalPoint);
        log.info("IN save - rentalPoint: {} successfully created", rentalPoint);
        return rentalPoint;
    }

    @Override
    public void delete(Long id) {
        rentalPointRepository.deleteById(id);
        log.info("IN delete - rentalPoint with id: {} successfully deleted", id);
    }

    @Override
    public List<RentalPoint> findAll() {
        List<RentalPoint> result = rentalPointRepository.findAll();
        log.info("IN findAll - {} rentalPoints found", result.size());
        return result;
    }

    @Override
    public RentalPoint findById(Long id) {
        RentalPoint result = rentalPointRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no rentalPoint found by id: {}", id);
            return null;
        }

        log.info("IN findById - rentalPoint: {} found by id: {}", result, id);
        return result;
    }
}
