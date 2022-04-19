package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import com.senla.scooterrentalapp.repository.RentalPointParentRepository;
import com.senla.scooterrentalapp.service.RentalPointParentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RentalPointParentServiceImpl implements RentalPointParentService {

    private final RentalPointParentRepository rentalPointParentRepository;

    @Autowired
    public RentalPointParentServiceImpl(RentalPointParentRepository rentalPointParentRepository) {
        this.rentalPointParentRepository = rentalPointParentRepository;
    }

    @Override
    public RentalPointParent save(RentalPointParent rentalPointParent) {
        rentalPointParentRepository.save(rentalPointParent);
        log.info("IN save - rentalPointParent: {} successfully created", rentalPointParent);
        return rentalPointParent;
    }

    @Override
    public void delete(Long id) {
        rentalPointParentRepository.deleteById(id);
        log.info("IN delete - rentalPointParent with id: {} successfully deleted", id);
    }

    @Override
    public List<RentalPointParent> findAll() {
        List<RentalPointParent> result = rentalPointParentRepository.findAll();
        log.info("IN findAll - {} rentalPointParents found", result.size());
        return result;
    }

    @Override
    public RentalPointParent findById(Long id) {
        RentalPointParent result = rentalPointParentRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no rentalPointParent found by id: {}", id);
            return null;
        }

        log.info("IN findById - rentalPointParent: {} found by id: {}", result, id);
        return result;
    }
}
