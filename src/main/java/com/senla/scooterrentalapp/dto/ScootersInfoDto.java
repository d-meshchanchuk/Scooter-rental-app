package com.senla.scooterrentalapp.dto;

import com.senla.scooterrentalapp.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ScootersInfoDto {
    private Long id;
    private Date created;
    private Long scooterId;
    private Long rentalPointId;
    private Integer engineHours;
    private Status status;
}
