package com.senla.scooterrentalapp.dto.tariff;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TariffDto {
    private Long id;
    private String name;
    private Integer hours;
    private Double pricePerHour;
}
