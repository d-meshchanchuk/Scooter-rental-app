package com.senla.scooterrentalapp.dto.rentalpoint;

import com.senla.scooterrentalapp.entity.rentalpoint.RentalPointParent;
import lombok.Data;

@Data
public class RentalPointParentDto {
    private Long id;
    private String name;
    private Long parentId;

    public RentalPointParent toRentalPointParent() {
        RentalPointParent rentalPointParent = new RentalPointParent();
        rentalPointParent.setId(id);
        rentalPointParent.setName(name);
        rentalPointParent.setParentId(parentId);

        return rentalPointParent;
    }

    public static RentalPointParentDto fromRentalPointParent(RentalPointParent rentalPointParent) {
        RentalPointParentDto rentalPointParentDto = new RentalPointParentDto();
        rentalPointParentDto.setId(rentalPointParent.getId());
        rentalPointParentDto.setName(rentalPointParent.getName());
        rentalPointParentDto.setParentId(rentalPointParent.getParentId());

        return rentalPointParentDto;
    }
}
