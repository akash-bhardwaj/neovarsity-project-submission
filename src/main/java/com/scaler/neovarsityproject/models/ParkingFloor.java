package com.scaler.neovarsityproject.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private String name;
    private List<ParkingSpot> parkingSpotList = new ArrayList<>();

}
