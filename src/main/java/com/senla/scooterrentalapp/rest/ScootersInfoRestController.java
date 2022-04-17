package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/scootersInfo/")
public class ScootersInfoRestController {

    private final ScootersInfoService scootersInfoService;

    @Autowired
    public ScootersInfoRestController(ScootersInfoService scootersInfoService) {
        this.scootersInfoService = scootersInfoService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ScootersInfo> getScootersInfoById(@PathVariable(name = "id") Long id) {
        ScootersInfo scootersInfo = scootersInfoService.findById(id);

        if (scootersInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scootersInfo, HttpStatus.OK);
    }

    @GetMapping(value = "get/{scooter}")
    public ResponseEntity<List<ScootersInfo>> getScootersInfoByScooter(@PathVariable(name = "scooter") Scooter scooter) {
        List<ScootersInfo> scootersInfoList = scootersInfoService.findByScooter(scooter);

        if (scootersInfoList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scootersInfoList, HttpStatus.OK);
    }

    @GetMapping(value = "get/{status}")
    public ResponseEntity<List<ScootersInfo>> getScootersInfoByStatus(@PathVariable(name = "status") Status status) {
        List<ScootersInfo> scootersInfoList = scootersInfoService.findByStatus(status);

        if (scootersInfoList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scootersInfoList, HttpStatus.OK);
    }

    @GetMapping(value = "get/{rentalPoint}")
    public ResponseEntity<List<ScootersInfo>> getScootersInfoByRentalPoint(@PathVariable(name = "rentalPoint") RentalPoint rentalPoint) {
        List<ScootersInfo> scootersInfoList = scootersInfoService.findByRentalPoint(rentalPoint);

        if (scootersInfoList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scootersInfoList, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ScootersInfo>> getAll() {
        List<ScootersInfo> scootersInfoList = scootersInfoService.findAll();

        if (scootersInfoList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(scootersInfoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ScootersInfo scootersInfo) {
        scootersInfoService.save(scootersInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        scootersInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
