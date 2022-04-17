package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import com.senla.scooterrentalapp.service.TariffPricesService;
import com.senla.scooterrentalapp.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TariffPrices> getTariffPricesById(@PathVariable(name = "id") Long id) {
        TariffPrices tariffPrices = tariffPricesService.findById(id);

        if (tariffPrices == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariffPrices, HttpStatus.OK);
    }

    @GetMapping(value = "current/{id}")
    public ResponseEntity<TariffPrices> getCurrentTariffPricesById(@PathVariable(name = "id") Long id) {
        TariffPrices tariffPrices = tariffPricesService.findCurrentTariff(tariffService.findById(id));

        if (tariffPrices == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariffPrices, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TariffPrices>> getAll() {
        List<TariffPrices> tariffPricesList = tariffPricesService.findAll();

        if (tariffPricesList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariffPricesList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TariffPrices tariffPrices) {
        tariffPricesService.save(tariffPrices);
        return new ResponseEntity<>(HttpStatus.OK);
        //todo какую ошибку отловить?
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        tariffPricesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
