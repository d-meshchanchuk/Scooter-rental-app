package com.senla.scooterrentalapp.dto.tariff;

import com.senla.scooterrentalapp.entity.tariff.Tariff;
import lombok.Data;

@Data
public class TariffDto {
    private Long id;
    private String name;
    private Integer hours;
    private Double pricePerHour;

    public Tariff toTariff() {
        Tariff tariff = new Tariff();
        tariff.setId(id);
        tariff.setName(name);
        tariff.setHours(hours);
        tariff.setPricePerHour(pricePerHour);

        return tariff;
    }

    public static TariffDto fromTariff(Tariff tariff) {
        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(tariff.getId());
        tariffDto.setName(tariff.getName());
        tariffDto.setHours(tariff.getHours());
        tariffDto.setPricePerHour(tariff.getPricePerHour());

        return tariffDto;
    }
}
