package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.mapper.ScooterMapper;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ScooterServiceImpl implements ScooterService {

    private final ScooterRepository scooterRepository;

    @Override
    public ScooterDto save(ScooterDto scooterDto) {
        scooterRepository.save(ScooterMapper.SCOOTER_MAPPER.toScooter(scooterDto));
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
        var result = scooters.stream().map(ScooterMapper.SCOOTER_MAPPER::fromScooter).collect(Collectors.toList());
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

        ScooterDto result = ScooterMapper.SCOOTER_MAPPER.fromScooter(scooter);

        log.info("IN findById - scooter: {} found by id: {}", result, id);
        return result;
    }
}
