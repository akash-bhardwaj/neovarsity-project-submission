package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SlotAllocationService {

    private final ParkingSpotRepository parkingSpotRepository;
    public ParkingSpot allocateSlotBasedOnVehicleType (VehicleType vehicleType) {
        return parkingSpotRepository
                .findByVehicleTypeAndSpotStatus(vehicleType, SpotStatus.AVAILABLE).stream().findFirst().orElse(null);
    }
}
