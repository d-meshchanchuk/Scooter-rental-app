package com.senla.scooterrentalapp.dto.tariff;

import lombok.Data;

@Data
public class TariffDto {
    private Long id;
    private String name;
    private Integer hours;
    private Double pricePerHour;
}
