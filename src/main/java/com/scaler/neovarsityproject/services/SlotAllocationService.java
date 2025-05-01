package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;

public class SlotAllocationService {

    private final ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public ParkingSpot allocateSlotBasedOnVehicleType (VehicleType vehicleType) {
        return parkingSpotRepository.findParkingSpotByVehicleTypeAndStatusAvailable(vehicleType);
    }
}
