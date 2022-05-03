package com.senla.scooterrentalapp.dto.scooter;

import com.senla.scooterrentalapp.entity.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScootersInfoDto {
    private Long id;
    private LocalDateTime created;
    private Long scooterId;
    private Long rentalPointId;
    private Integer engineHours;
    private Status status;
}
