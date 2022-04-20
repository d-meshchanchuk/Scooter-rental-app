package com.senla.scooterrentalapp.dto.scooter;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import lombok.Data;

import java.util.Date;

@Data
public class ScootersInfoDto {
    private Long id;
    private Date created;
    private Long scooterId;
    private Long rentalPointId;
    private Integer engineHours;
    private Status status;

    public static ScootersInfoDto fromScooterInfo(ScootersInfo scootersInfo) {
        ScootersInfoDto scootersInfoDto = new ScootersInfoDto();
        scootersInfoDto.setId(scootersInfo.getId());
        scootersInfoDto.setCreated(scootersInfo.getCreated());
        scootersInfoDto.setScooterId(scootersInfo.getScooter().getId());
        scootersInfoDto.setRentalPointId(scootersInfo.getRentalPoint().getId());
        scootersInfoDto.setEngineHours(scootersInfo.getEngineHours());
        scootersInfoDto.setStatus(scootersInfo.getStatus());

        return scootersInfoDto;
    }
}
