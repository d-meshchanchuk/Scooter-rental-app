package com.senla.scooterrentalapp.entity.rentalpoint;

import com.senla.scooterrentalapp.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rental_point_parents")
public class RentalPointParent extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer Long;
}
