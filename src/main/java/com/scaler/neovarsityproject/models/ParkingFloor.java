package com.scaler.neovarsityproject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @Builder.Default
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<ParkingSpot> parkingSpotList = new ArrayList<>();

    @OneToOne
    private PaymentCounter paymentCounter;

}
