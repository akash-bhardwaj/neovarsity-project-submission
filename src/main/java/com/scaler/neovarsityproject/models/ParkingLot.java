package com.scaler.neovarsityproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class ParkingLot extends BaseModel {
    private String name;
    private String address;

    @Builder.Default
    private List<ParkingFloor> floors = new ArrayList<>();

    @Builder.Default
    private List<ParkingFloor> entryGates = new ArrayList<>();

    @Builder.Default
    private List<ParkingFloor> exitGates = new ArrayList<>();

}
