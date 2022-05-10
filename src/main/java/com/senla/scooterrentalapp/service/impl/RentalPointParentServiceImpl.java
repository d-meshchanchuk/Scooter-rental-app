package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointParentDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import com.senla.scooterrentalapp.mapper.RentalPointParentMapper;
import com.senla.scooterrentalapp.repository.RentalPointParentRepository;
import com.senla.scooterrentalapp.service.RentalPointParentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class RentalPointParentServiceImpl implements RentalPointParentService {

    private final RentalPointParentRepository rentalPointParentRepository;
    private final RentalPointParentMapper rentalPointParentMapper;

    @Override
    public RentalPointParentDto save(RentalPointParentDto rentalPointParentDto) {
        rentalPointParentRepository.save(rentalPointParentMapper.toRentalPointParent(rentalPointParentDto));
        log.info("IN save - rentalPointParent: {} successfully created", rentalPointParentDto);
        return rentalPointParentDto;
    }

    @Override
    public void delete(Long id) {
        rentalPointParentRepository.deleteById(id);
        log.info("IN delete - rentalPointParent with id: {} successfully deleted", id);
    }

    @Override
    public List<RentalPointParentDto> findAll() {
        List<RentalPointParent> rentalPointParents = rentalPointParentRepository.findAll();
        var result = rentalPointParents.stream().map(rentalPointParentMapper::fromRentalPointParent).collect(Collectors.toList());
        log.info("IN findAll - {} rentalPointParents found", result.size());
        return result;
    }

    @Override
    public RentalPointParentDto findById(Long id) {
        RentalPointParent rentalPointParent = rentalPointParentRepository.findById(id).orElse(null);

        if (rentalPointParent == null) {
            log.warn("IN findById - no rentalPointParent found by id: {}", id);
            return null;
        }

        RentalPointParentDto result = rentalPointParentMapper.fromRentalPointParent(rentalPointParent);

        log.info("IN findById - rentalPointParent: {} found by id: {}", result, id);
        return result;
    }
}
