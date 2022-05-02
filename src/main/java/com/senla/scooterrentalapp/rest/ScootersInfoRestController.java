package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.service.RentalPointService;
import com.senla.scooterrentalapp.service.ScooterService;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/scootersInfo/")
public class ScootersInfoRestController {

    private final ScootersInfoService scootersInfoService;
    private final ScooterService scooterService;
    private final RentalPointService rentalPointService;

    @GetMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ScootersInfoDto> getScootersInfoById(@PathVariable(name = "id") Long id) {
        ScootersInfoDto result = scootersInfoService.findById(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<ScootersInfoDto>> getScootersInfoByScooter(@RequestParam String param, @PathVariable(name = "id") Long id) {
        List<ScootersInfoDto> result = switch (param) {
            case ("scooter") -> scootersInfoService.findByScooter(scooterService.findById(id));
            case ("rentalPoint") -> scootersInfoService.findByRentalPoint(rentalPointService.findById(id));
            default -> scootersInfoService.findAll();
        };

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "getByStatus/{status}")
    public ResponseEntity<List<ScootersInfoDto>> getScootersInfoByStatus(@PathVariable(name = "status") Status status) {
        List<ScootersInfoDto> result = scootersInfoService.findByStatus(status);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<ScootersInfoDto>> getAll() {
        List<ScootersInfoDto> result = scootersInfoService.findAll();

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> save(@RequestBody ScootersInfoDto scootersInfoDto) {
        scootersInfoService.save(scootersInfoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        scootersInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
