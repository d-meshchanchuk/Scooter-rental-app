package com.senla.scooterrentalapp.dto;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.tariff.TariffPrices;
import com.senla.scooterrentalapp.entity.user.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderDto {

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_price_id")
    private TariffPrices tariffPrices;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scooter_id")
    private Scooter scooter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_point_id")
    private RentalPoint startPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_point_id")
    private RentalPoint finishPoint;
}
