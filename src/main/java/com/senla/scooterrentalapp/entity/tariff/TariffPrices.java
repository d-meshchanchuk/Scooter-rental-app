package com.senla.scooterrentalapp.entity.tariff;

import com.senla.scooterrentalapp.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tariff_prices")
@Data
public class TariffPrices extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "price_per_hour")
    private Double pricePerHour;
}
