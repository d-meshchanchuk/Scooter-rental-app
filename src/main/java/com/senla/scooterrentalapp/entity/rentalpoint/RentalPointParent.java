package com.senla.scooterrentalapp.entity.rentalpoint;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rental_point_parents")
public class RentalPointParent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Long parentId;
}
