package com.scaler.neovarsityproject.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Vehicle extends BaseModel {
    private VehicleType type;
}
