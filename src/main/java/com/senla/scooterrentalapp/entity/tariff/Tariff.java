package com.senla.scooterrentalapp.entity.tariff;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "tariffs")
@Data
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Min(0)
    @Column(name = "hours")
    private Integer hours;

    @Min(0)
    @Column(name = "price_per_hour")
    private Double pricePerHour;

    @Override
    public String toString() {
        return "Tariff{" +
                "id: " + id + ", " +
                "name: " + name +
                "hours: " + hours + "}";
    }
}
