package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.service.RentalPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/rentalPoints/")
public class RentalPointRestController {

    private final RentalPointService rentalPointService;

    @Autowired
    public RentalPointRestController(RentalPointService rentalPointService) {
        this.rentalPointService = rentalPointService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<RentalPointDto> getRentalPointById(@PathVariable(name = "id") Long id) {
        RentalPoint rentalPoint = rentalPointService.findById(id);

        if (rentalPoint == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        RentalPointDto result = RentalPointDto.fromRentalPoint(rentalPoint);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RentalPoint>> getAll() {
        List<RentalPoint> rentalPointList = rentalPointService.findAll();

        if (rentalPointList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rentalPointList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RentalPointDto rentalPointDto) {
        //rentalPointService.save(rentalPointDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        rentalPointService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
