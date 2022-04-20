package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScooterServiceImpl implements ScooterService {

    private final ScooterRepository scooterRepository;

    @Autowired
    public ScooterServiceImpl(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    @Override
    public ScooterDto save(ScooterDto scooterDto) {
        scooterRepository.save(scooterDto.toScooter());
        log.info("IN save - scooter: {} successfully created", scooterDto);
        return scooterDto;
    }

    @Override
    public void delete(Long id) {
        scooterRepository.deleteById(id);
        log.info("IN delete - scooter with id: {} successfully deleted", id);
    }

    @Override
    public List<ScooterDto> findAll() {
        List<Scooter> scooters = scooterRepository.findAll();
        var result = scooters.stream().map(ScooterDto::fromScooter).collect(Collectors.toList());
        log.info("IN findAll - {} scooters found", result.size());
        return result;
    }

    @Override
    public ScooterDto findById(Long id) {
        Scooter scooter = scooterRepository.findById(id).orElse(null);

        if (scooter == null) {
            log.warn("IN findById - no scooter found by id: {}", id);
            return null;
        }

        ScooterDto result = ScooterDto.fromScooter(scooter);

        log.info("IN findById - scooter: {} found by id: {}", result, id);
        return result;
    }
}
