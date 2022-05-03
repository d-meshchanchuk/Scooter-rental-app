package com.senla.scooterrentalapp.dto.scooter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScooterDto {
    private Long id;
    private String model;
    private Integer power;
}
