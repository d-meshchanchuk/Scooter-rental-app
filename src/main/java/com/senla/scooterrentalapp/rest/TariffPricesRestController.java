package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.tariff.TariffPricesDto;
import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import com.senla.scooterrentalapp.service.TariffPricesService;
import com.senla.scooterrentalapp.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tariffPrices/")
public class TariffPricesRestController {

    private final TariffPricesService tariffPricesService;
    private final TariffService tariffService;

    @Autowired
    public TariffPricesRestController(TariffPricesService tariffPricesService, TariffService tariffService) {
        this.tariffPricesService = tariffPricesService;
        this.tariffService = tariffService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TariffPricesDto> getTariffPricesById(@PathVariable(name = "id") Long id) {
        TariffPrices tariffPrices = tariffPricesService.findById(id);

        if (tariffPrices == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        TariffPricesDto result = TariffPricesDto.fromTariffPrices(tariffPrices);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "current/{id}")
    public ResponseEntity<TariffPricesDto> getCurrentTariffPricesById(@PathVariable(name = "id") Long id) {
        TariffPrices tariffPrices = tariffPricesService.findCurrentTariff(tariffService.findById(id));

        if (tariffPrices == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        TariffPricesDto result = TariffPricesDto.fromTariffPrices(tariffPrices);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TariffPricesDto>> getAll() {
        List<TariffPrices> tariffPricesList = tariffPricesService.findAll();

        if (tariffPricesList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<TariffPricesDto> result = new ArrayList<>();
        tariffPricesList.forEach(tariffPrices -> result.add(TariffPricesDto.fromTariffPrices(tariffPrices)));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TariffPricesDto tariffPricesDto) {
        TariffPrices tariffPrices = TariffPrices.builder()
                .created(new Date())
                .tariff(tariffService.findById(tariffPricesDto.getTariffId()))
                .hours(tariffPricesDto.getHours())
                .pricePerHour(tariffPricesDto.getPricePerHour())
                .build();
        tariffPricesService.save(tariffPrices);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        tariffPricesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
