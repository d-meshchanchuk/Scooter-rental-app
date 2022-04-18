package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.service.TariffPricesService;
import com.senla.scooterrentalapp.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tariffs/")
public class TariffRestController {

    private final TariffService tariffService;

    @Autowired
    public TariffRestController(TariffService tariffService, TariffPricesService tariffPricesService) {
        this.tariffService = tariffService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TariffDto> getTariffById(@PathVariable(name = "id") Long id) {
        Tariff tariff = tariffService.findById(id);

        if (tariff == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        TariffDto result = TariffDto.fromTariff(tariff);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TariffDto>> getAll() {
        List<Tariff> tariffs = tariffService.findAll();

        if (tariffs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<TariffDto> result = new ArrayList<>();
        tariffs.forEach(tariff -> result.add(TariffDto.fromTariff(tariff)));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TariffDto tariffDto) {
        Tariff tariff = tariffDto.toTariff();
        tariffService.save(tariff);
        return new ResponseEntity<>(HttpStatus.OK);
        //todo какую ошибку отловить?
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        tariffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
