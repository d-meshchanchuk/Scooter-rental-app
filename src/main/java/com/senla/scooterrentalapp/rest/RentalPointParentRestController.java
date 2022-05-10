package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointParentDto;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.service.RentalPointParentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/rentalPointParent/")
public class RentalPointParentRestController {

    private final RentalPointParentService rentalPointParentService;

    @GetMapping(value = "{id}")
    public ResponseEntity<RentalPointParentDto> getRentalPointById(@PathVariable(name = "id") Long id) throws NoContentException {
        RentalPointParentDto result = rentalPointParentService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RentalPointParentDto>> getAll() {
        List<RentalPointParentDto> result = rentalPointParentService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> save(@RequestBody RentalPointParentDto rentalPointParentDto) {
        rentalPointParentService.save(rentalPointParentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        rentalPointParentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
