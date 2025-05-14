package com.scaler.neovarsityproject.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@Entity
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpot> parkingSpotList;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PaymentCounter paymentCounter;
}
