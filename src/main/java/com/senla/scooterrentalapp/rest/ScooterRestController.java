package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/scooters/")
public class ScooterRestController {

    public final ScooterService scooterService;

    @Autowired
    public ScooterRestController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ScooterDto> getTariffById(@PathVariable(name = "id") Long id) {
        Scooter scooter = scooterService.findById(id);

        if (scooter == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ScooterDto result = ScooterDto.fromScooter(scooter);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ScooterDto>> getAll() {
        List<Scooter> scooters = scooterService.findAll();

        if (scooters == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<ScooterDto> result = new ArrayList<>();
        scooters.forEach(scooter -> result.add(ScooterDto.fromScooter(scooter)));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ScooterDto scooterDto) {
        scooterService.save(scooterDto.toScooter());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        scooterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
