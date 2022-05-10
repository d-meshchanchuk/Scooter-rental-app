package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.service.RentalPointService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/rentalPoints/")
public class RentalPointRestController {

    private final RentalPointService rentalPointService;

    @GetMapping(value = "{id}")
    public ResponseEntity<RentalPointDto> getRentalPointById(@PathVariable(name = "id") Long id) throws NoContentException {
        RentalPointDto result = rentalPointService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RentalPointDto>> getAll() {
        List<RentalPointDto> result = rentalPointService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> save(@RequestBody RentalPointDto rentalPointDto) {
        rentalPointService.save(rentalPointDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        rentalPointService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
