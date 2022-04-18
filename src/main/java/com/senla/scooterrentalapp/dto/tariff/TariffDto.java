package com.senla.scooterrentalapp.dto.tariff;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TariffDto {
    private Long id;
    private String name;
    private Integer hours;
}
