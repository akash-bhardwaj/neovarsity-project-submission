package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {

    List<ParkingSpot> parkingSpotList = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
        return parkingSpot;
    }

    public List<ParkingSpot> saveAll(List<ParkingSpot> parkingSpots) {
        this.parkingSpotList.addAll(parkingSpots);
        return parkingSpots;
    }


    public ParkingSpot findParkingSpotByVehicleTypeAndStatusAvailable (VehicleType vehicleType) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if(parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == vehicleType) {
                return parkingSpot;
            }
        }
        return null;
    }
}
