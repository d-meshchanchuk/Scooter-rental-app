package com.senla.scooterrentalapp.entity;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import com.senla.scooterrentalapp.entity.scooter.Scooter;
import com.senla.scooterrentalapp.entity.tariff.Tariff;
import com.senla.scooterrentalapp.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @Min(0)
    @Column(name = "hours")
    private Integer hours;

    @Min(0)
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
    @JoinColumn(name = "finish_point_id")
    private RentalPoint finishPoint;

    @Column(name = "created")
    private Date created;

    @Column(name = "closed")
    private Date closed;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
