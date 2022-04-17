package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.service.TariffPricesService;
import com.senla.scooterrentalapp.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Tariff> getTariffById(@PathVariable(name = "id") Long id) {
        Tariff tariff = tariffService.findById(id);

        if (tariff == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariff, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Tariff>> getAll() {
        List<Tariff> tariffs = tariffService.findAll();

        if (tariffs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariffs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Tariff tariff) {
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
