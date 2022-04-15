package com.senla.scooterrentalapp.entity.scooter;

import com.senla.scooterrentalapp.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scooters")
public class Scooter extends BaseEntity {

    @Column(name = "model")
    private String model;

    @Column(name = "power")
    private Integer power;
}
