package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.scooter.ScooterDto;
import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/scootersInfo/")
public class ScootersInfoRestController {

    private final ScootersInfoService scootersInfoService;

    @GetMapping(value = "{id}")
    public ResponseEntity<ScootersInfoDto> getScootersInfoById(@PathVariable(name = "id") Long id) {
        ScootersInfoDto result = scootersInfoService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{scooter}")
    public ResponseEntity<List<ScootersInfoDto>> getScootersInfoByScooter(@PathVariable(name = "scooter") ScooterDto scooterDto) {
        List<ScootersInfoDto> result = scootersInfoService.findByScooter(scooterDto);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{status}")
    public ResponseEntity<List<ScootersInfoDto>> getScootersInfoByStatus(@PathVariable(name = "status") Status status) {
        List<ScootersInfoDto> result = scootersInfoService.findByStatus(status);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{rentalPoint}")
    public ResponseEntity<List<ScootersInfoDto>> getScootersInfoByRentalPoint(@PathVariable(name = "rentalPoint") RentalPoint rentalPoint) {
        List<ScootersInfoDto> result = scootersInfoService.findByRentalPoint(rentalPoint);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ScootersInfoDto>> getAll() {
        List<ScootersInfoDto> result = scootersInfoService.findAll();

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ScootersInfoDto scootersInfoDto) {
        scootersInfoService.save(scootersInfoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        scootersInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
