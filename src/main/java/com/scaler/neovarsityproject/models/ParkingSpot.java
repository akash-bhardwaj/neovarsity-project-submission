package com.scaler.neovarsityproject.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ParkingSpot extends BaseModel {
    private Integer spotId;
    private Integer floorNumber;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;

    public static ParkingSpot spotAvailableForMediumVehicle() {
        return ParkingSpot
                .builder()
                .vehicleType(VehicleType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }
}
