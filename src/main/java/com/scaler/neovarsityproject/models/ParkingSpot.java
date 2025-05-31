package com.scaler.neovarsityproject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class ParkingSpot extends BaseModel {
    private Integer spotId;
    private Integer floorNumber;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;
    @ManyToOne
    @JoinColumn(name = "floor_id")
    private ParkingFloor floor;
}
