package com.scaler.neovarsityproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private String name;
    @Builder.Default
    private List<ParkingSpot> parkingSpotList = new ArrayList<>();

    private PaymentCounter paymentCounter;

}
