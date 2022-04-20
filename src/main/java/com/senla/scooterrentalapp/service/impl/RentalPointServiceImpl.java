package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.repository.RentalPointParentRepository;
import com.senla.scooterrentalapp.repository.RentalPointRepository;
import com.senla.scooterrentalapp.service.RentalPointService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class RentalPointServiceImpl implements RentalPointService {

    private final RentalPointRepository rentalPointRepository;
    private final RentalPointParentRepository rentalPointParentRepository;

    @Override
    public RentalPointDto save(RentalPointDto rentalPointDto) {
        RentalPoint rentalPoint = RentalPoint.builder()
                .id(rentalPointDto.getId())
                .parent(rentalPointParentRepository.getById(rentalPointDto.getParentId()))
                .location(rentalPointDto.getLocation())
                .longitude(rentalPointDto.getLongitude())
                .latitude(rentalPointDto.getLatitude())
                .build();
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
        var result = rentalPoints.stream().map(RentalPointDto::fromRentalPoint).collect(Collectors.toList());
        log.info("IN findAll - {} rentalPoints found", result.size());
        return result;
    }

    @Override
    public RentalPointDto findById(Long id) {
        RentalPoint rentalPoints = rentalPointRepository.findById(id).orElse(null);

        if (rentalPoints == null) {
            log.warn("IN findById - no rentalPoint found by id: {}", id);
            return null;
        }

        RentalPointDto result = RentalPointDto.fromRentalPoint(rentalPoints);

        log.info("IN findById - rentalPoint: {} found by id: {}", result, id);
        return result;
    }
}
