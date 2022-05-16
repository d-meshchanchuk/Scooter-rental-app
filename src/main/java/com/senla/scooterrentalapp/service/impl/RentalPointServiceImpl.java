package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.mapper.RentalPointMapper;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.service.RentalPointService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class RentalPointServiceImpl implements RentalPointService {

    private final RentalPointRepository rentalPointRepository;
    private final RentalPointMapper rentalPointMapper;

    @Override
    public RentalPointDto save(RentalPointDto rentalPointDto) {
        RentalPoint rentalPoint = rentalPointMapper.toRentalPoint(rentalPointDto);
        rentalPointRepository.save(rentalPoint);
        log.info("IN save - rentalPoint: {} successfully created", rentalPointDto);
        return rentalPointDto;
    }

    @Override
    public void delete(Long id) {
        rentalPointRepository.deleteById(id);
        log.info("IN delete - rentalPoint with id: {} successfully deleted", id);
    }

    @Override
    public List<RentalPointDto> findAll() {
        List<RentalPoint> rentalPoints = rentalPointRepository.findAll();
        var result = rentalPoints.stream().map(rentalPointMapper::fromRentalPoint).collect(Collectors.toList());
        log.info("IN findAll - {} rentalPoints found", result.size());
        return result;
    }

    @Override
    public RentalPointDto findById(Long id) throws NoContentException {
        Optional<RentalPoint> rentalPoint = rentalPointRepository.findById(id);

        if (rentalPoint.isEmpty()) {
            log.warn("IN findById - no rentalPoint found by id: {}", id);
            throw new NoContentException();
        }

        RentalPointDto result = rentalPointMapper.fromRentalPoint(rentalPoint.get());

        log.info("IN findById - rentalPoint: {} found by id: {}", result, id);
        return result;
    }
}
