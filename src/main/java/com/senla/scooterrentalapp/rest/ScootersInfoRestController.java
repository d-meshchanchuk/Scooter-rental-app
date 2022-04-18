package com.senla.scooterrentalapp.rest;

import com.senla.scooterrentalapp.dto.scooter.ScootersInfoDto;
import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import com.senla.scooterrentalapp.service.RentalPointService;
import com.senla.scooterrentalapp.service.ScooterService;
import com.senla.scooterrentalapp.service.ScootersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/scootersInfo/")
public class ScootersInfoRestController {

    private final ScootersInfoService scootersInfoService;
    private final ScooterService scooterService;
    private final RentalPointService rentalPointService;

    @Autowired
    public ScootersInfoRestController(ScootersInfoService scootersInfoService, ScooterService scooterService, RentalPointService rentalPointService) {
        this.scootersInfoService = scootersInfoService;
        this.scooterService = scooterService;
        this.rentalPointService = rentalPointService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ScootersInfoDto> getScootersInfoById(@PathVariable(name = "id") Long id) {
        ScootersInfo scootersInfo = scootersInfoService.findById(id);

        if (scootersInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ScootersInfoDto result = ScootersInfoDto.fromScooterInfo(scootersInfo);

        return new ResponseEntity<>(result, HttpStatus.OK);
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
    public ResponseEntity<?> save(@RequestBody ScootersInfoDto scootersInfoDto) {
        ScootersInfo scootersInfo = new ScootersInfo();
        scootersInfo.setCreated(new Date());
        scootersInfo.setScooter(scooterService.findById(scootersInfoDto.getScooterId()));
        scootersInfo.setRentalPoint(rentalPointService.findById(scootersInfoDto.getRentalPointId()));
        scootersInfo.setEngineHours(scootersInfoDto.getEngineHours());
        scootersInfo.setStatus(scootersInfoDto.getStatus());
        scootersInfoService.save(scootersInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        scootersInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
