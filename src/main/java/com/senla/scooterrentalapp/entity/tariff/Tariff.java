package com.senla.scooterrentalapp.entity.tariff;

import com.senla.scooterrentalapp.entity.BaseEntity;
import com.senla.scooterrentalapp.entity.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariffs")
@Data
public class Tariff extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Tariff{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}
