package com.senla.scooterrentalapp.entity.tariff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tariff_prices")
@Data
public class TariffPrices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "price_per_hour")
    private Double pricePerHour;
}
