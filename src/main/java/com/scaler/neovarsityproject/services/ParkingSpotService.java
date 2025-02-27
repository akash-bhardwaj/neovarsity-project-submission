package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingLot;
import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public List<ParkingSpot> createSpots(ParkingLot parkingLot) {
        List<ParkingSpot> parkingSpots = parkingLot
                .getFloors()
                .stream()
                .flatMap(floor -> floor.getParkingSpotList().stream())
                .collect(Collectors.toList());
        return parkingSpotRepository.saveAll(parkingSpots);
    }
    public void markSlotBooked(ParkingSpot parkingSpot) {
        parkingSpotRepository.save(parkingSpot);
    }
}
