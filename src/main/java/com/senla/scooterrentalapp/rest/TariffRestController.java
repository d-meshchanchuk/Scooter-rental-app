package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
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
    public TariffRestController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TariffDto> getTariffById(@PathVariable(name = "id") Long id) {
        TariffDto tariffDto = tariffService.findById(id);

        if (tariffDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariffDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TariffDto>> getAll() {
        List<TariffDto> tariffs = tariffService.findAll();

        if (tariffs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tariffs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TariffDto tariffDto) {
        tariffService.save(tariffDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        tariffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
