package com.senla.scooterrentalapp.dto.rentalpoint;

import lombok.Data;

@Data
public class RentalPointDto {
    private Long id;
    private Long parentId;
    private String location;
    private String latitude;
    private String longitude;
}
