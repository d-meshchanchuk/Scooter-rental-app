package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.service.RentalPointService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/rentalPoints/")
public class RentalPointRestController {

    private final RentalPointService rentalPointService;

    @GetMapping(value = "{id}")
    public ResponseEntity<RentalPointDto> getRentalPointById(@PathVariable(name = "id") Long id) {
        RentalPointDto result = rentalPointService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RentalPointDto>> getAll() {
        List<RentalPointDto> result = rentalPointService.findAll();

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RentalPointDto rentalPointDto) {
        rentalPointService.save(rentalPointDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        rentalPointService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
