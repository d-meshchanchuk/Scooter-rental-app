package com.senla.scooterrentalapp.dto.rentalpoint;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPoint;
import lombok.Data;

@Data
public class RentalPointDto {
    private Long id;
    private Long parentId;
    private String location;
    private String latitude;
    private String longitude;

    public static RentalPointDto fromRentalPoint(RentalPoint rentalPoint) {
        RentalPointDto rentalPointDto = new RentalPointDto();
        rentalPointDto.setId(rentalPoint.getId());
        rentalPointDto.setParentId(rentalPoint.getParent().getId());
        rentalPointDto.setLocation(rentalPoint.getLocation());
        rentalPointDto.setLatitude(rentalPoint.getLatitude());
        rentalPointDto.setLongitude(rentalPoint.getLongitude());

        return rentalPointDto;
    }
}
