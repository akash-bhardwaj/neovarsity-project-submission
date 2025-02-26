package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {
    private final List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
        return parkingLot;
    }
}
