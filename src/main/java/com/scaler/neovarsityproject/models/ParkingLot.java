package com.scaler.neovarsityproject.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
@Entity
public class ParkingLot extends BaseModel {
    private String name;
    private String address;

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parking_floor_id")
    private List<ParkingFloor> floors = new ArrayList<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "entry_gate_id")
    private List<EntryGate> entryGates = new ArrayList<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "exit_gate_id")
    private List<ExitGate> exitGates = new ArrayList<>();

}
