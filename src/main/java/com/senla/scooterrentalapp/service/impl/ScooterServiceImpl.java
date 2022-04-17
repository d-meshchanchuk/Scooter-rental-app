package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ScooterServiceImpl implements ScooterService {

    private final ScooterRepository scooterRepository;

    @Autowired
    public ScooterServiceImpl(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    @Override
    public Scooter save(Scooter scooter) {
        scooterRepository.save(scooter);
        log.info("IN save - scooter: {} successfully created", scooter);
        return scooter;
    }

    @Override
    public void delete(Long id) {
        scooterRepository.deleteById(id);
        log.info("IN delete - scooter with id: {} successfully deleted", id);
    }

    @Override
    public List<Scooter> findAll() {
        List<Scooter> result = scooterRepository.findAll();
        log.info("IN findAll - {} scooters found", result.size());
        return result;
    }

    @Override
    public Scooter findById(Long id) {
        Scooter result = scooterRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no scooter found by id: {}", id);
            return null;
        }

        log.info("IN findById - scooter: {} found by id: {}", result, id);
        return result;
    }
}
