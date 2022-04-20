package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.service.ScooterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/scooters/")
public class ScooterRestController {

    public final ScooterService scooterService;

    @GetMapping(value = "{id}")
    public ResponseEntity<ScooterDto> getTariffById(@PathVariable(name = "id") Long id) {
        ScooterDto result = scooterService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ScooterDto>> getAll() {
        List<ScooterDto> result = scooterService.findAll();

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ScooterDto scooterDto) {
        scooterService.save(scooterDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        scooterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
