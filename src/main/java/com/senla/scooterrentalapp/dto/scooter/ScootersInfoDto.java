package com.senla.scooterrentalapp.dto.scooter;

import com.senla.scooterrentalapp.dto.rentalpoint.RentalPointDto;
import com.senla.scooterrentalapp.entity.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScootersInfoDto {
    private Long id;
    private LocalDateTime created;
    private ScooterDto scooter;
    private RentalPointDto rentalPoint;
    private Integer engineHours;
    private Status status;
}
