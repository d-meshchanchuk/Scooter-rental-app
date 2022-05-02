package com.senla.scooterrentalapp.dto.scooter;

import com.senla.scooterrentalapp.entity.Status;
import com.senla.scooterrentalapp.entity.scooter.ScootersInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ScootersInfoDto {
    private Long id;
    private LocalDateTime created;
    private Long scooterId;
    private Long rentalPointId;
    private Integer engineHours;
    private Status status;
}
