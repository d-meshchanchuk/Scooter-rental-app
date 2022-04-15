package com.senla.scooterrentalapp.entity.scooter;

import com.senla.scooterrentalapp.entity.BaseEntity;
import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scooters_info")
public class ScootersInfo extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scooter_id")
    private Scooter scooter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_points_id")
    private RentalPoint rentalPoint;

    @Column(name = "engine_hours")
    private Integer engineHours;
}
