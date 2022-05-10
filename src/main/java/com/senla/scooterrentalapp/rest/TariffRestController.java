package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.tariff.TariffDto;
import com.senla.scooterrentalapp.exception.NoContentException;
import com.senla.scooterrentalapp.service.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/tariffs/")
public class TariffRestController {

    private final TariffService tariffService;

    @GetMapping(value = "{id}")
    public ResponseEntity<TariffDto> getTariffById(@PathVariable(name = "id") Long id) throws NoContentException {
        TariffDto tariffDto = tariffService.findById(id);
        return new ResponseEntity<>(tariffDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TariffDto>> getAll() throws NoContentException {
        List<TariffDto> tariffs = tariffService.findAll();
        return new ResponseEntity<>(tariffs, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> save(@RequestBody TariffDto tariffDto) {
        tariffService.save(tariffDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        tariffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
