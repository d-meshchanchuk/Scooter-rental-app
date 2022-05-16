package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.mapper.ScooterMapper;
import com.senla.scooterrentalapp.repository.ScooterRepository;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScooterServiceImpl implements ScooterService {

    private final ScooterRepository scooterRepository;
    private final ScooterMapper scooterMapper;

    @Override
    public ScooterDto save(ScooterDto scooterDto) {
        scooterRepository.save(scooterMapper.toScooter(scooterDto));
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
        var result = scooters.stream().map(scooterMapper::fromScooter).collect(Collectors.toList());
        log.info("IN findAll - {} scooters found", result.size());
        return result;
    }

    @Override
    public ScooterDto findById(Long id) throws NoContentException {
        Optional<Scooter> scooter = scooterRepository.findById(id);

        if (scooter.isEmpty()) {
            log.warn("IN findById - no scooter found by id: {}", id);
            throw new NoContentException();
        }

        ScooterDto result = scooterMapper.fromScooter(scooter.get());

        log.info("IN findById - scooter: {} found by id: {}", result, id);
        return result;
    }
}
