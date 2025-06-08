package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingFloor;
import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.repositories.ParkingFloorRepository;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingFloorRepository parkingFloorRepository;

    public void persistParkingSpotsAndFloors (List<ParkingSpot> parkingSpotList, List<ParkingFloor> parkingFloorList) {
        parkingFloorRepository.saveAll(parkingFloorList);
        parkingSpotRepository.saveAll(parkingSpotList);
    }
    public void persistParkingSlot(ParkingSpot parkingSpot) {
        parkingSpotRepository.save(parkingSpot);
    }
}
