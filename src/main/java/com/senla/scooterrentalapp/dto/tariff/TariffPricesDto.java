package com.senla.scooterrentalapp.dto.tariff;

import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import lombok.Data;

import java.util.Date;

@Data
public class TariffPricesDto {
    private Long id;
    private Date created;
    private Long tariffId;
    private Integer hours;
    private Double pricePerHour;

    public static TariffPricesDto fromTariffPrices(TariffPrices tariffPrices) {
        TariffPricesDto tariffPricesDto = new TariffPricesDto();
        tariffPricesDto.setId(tariffPrices.getId());
        tariffPricesDto.setCreated(tariffPrices.getCreated());
        tariffPricesDto.setTariffId(tariffPrices.getTariff().getId());
        tariffPricesDto.setHours(tariffPrices.getHours());
        tariffPricesDto.setPricePerHour(tariffPrices.getPricePerHour());

        return tariffPricesDto;
    }
}
