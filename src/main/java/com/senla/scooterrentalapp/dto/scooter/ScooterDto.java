package com.senla.scooterrentalapp.dto.scooter;

import com.senla.scooterrentalapp.entity.scooter.Scooter;
import lombok.Data;

@Data
public class ScooterDto {
    private Long id;
    private String model;
    private Integer power;

    public Scooter toScooter() {
        Scooter scooter = new Scooter();
        scooter.setId(id);
        scooter.setModel(model);
        scooter.setPower(power);

        return scooter;
    }

    public static ScooterDto fromScooter(Scooter scooter) {
        ScooterDto scooterDto = new ScooterDto();
        scooterDto.setId(scooter.getId());
        scooterDto.setModel(scooter.getModel());
        scooterDto.setPower(scooter.getPower());

        return scooterDto;
    }
}
