package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Scooter> getTariffById(@PathVariable(name = "id") Long id) {
        Scooter scooter = scooterService.findById(id);

        if (scooter == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scooter, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Scooter>> getAll() {
        List<Scooter> scooters = scooterService.findAll();

        if (scooters == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scooters, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Scooter scooter) {
        scooterService.save(scooter);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        scooterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
