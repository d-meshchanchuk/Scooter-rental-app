package com.senla.scooterrentalapp.dto.tariff;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TariffPricesDto {
    private Long id;
    private Date created;
    private Long tariffId;
    private Integer hours;
    private Double pricePerHour;
}
