package com.senla.scooterrentalapp.service.impl;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.mapper.TariffMapper;
import com.senla.scooterrentalapp.repository.TariffRepository;
import com.senla.scooterrentalapp.service.TariffService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;

    @Override
    public TariffDto save(TariffDto tariffDto) {
        Tariff tariff = tariffMapper.toTariff(tariffDto);
        tariffRepository.save(tariff);
        log.info("IN save - tariff: {} successfully created", tariff);
        return tariffDto;
    }

    @Override
    public void delete(Long id) {
        tariffRepository.deleteById(id);
        log.info("IN delete - tariff with id: {} successfully deleted", id);
    }

    @Override
    public List<TariffDto> findAll() {
        List<Tariff> tariffs = tariffRepository.findAll();
        var result = tariffs.stream().map(tariffMapper::fromTariff).collect(Collectors.toList());
        log.info("IN findAll - {} tariffs found", result.size());
        return result;
    }

    @Override
    public TariffDto findById(Long id) throws NoContentException {
        Optional<Tariff> tariff = tariffRepository.findById(id);

        if (tariff.isEmpty()) {
            log.warn("IN findById - no tariff found by id: {}", id);
            throw new NoContentException();
        }

        TariffDto result = tariffMapper.fromTariff(tariff.get());

        log.info("IN findById - tariff: {} found by id: {}", result, id);
        return result;
    }
}
