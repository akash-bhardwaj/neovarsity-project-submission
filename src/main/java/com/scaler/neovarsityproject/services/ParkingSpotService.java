package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingLot;
import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.repositories.ParkingFloorRepository;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;
    private final ParkingFloorRepository parkingFloorRepository;

    public void createSpots(ParkingLot parkingLot) {
        List<ParkingSpot> parkingSpots = parkingLot
                .getFloors()
                .stream()
                .flatMap(floor -> floor.getParkingSpotList().stream())
                .collect(Collectors.toList());
        parkingSpots.forEach(parkingSpot -> parkingSpot.setFloor(parkingSpot.getFloor()));
        parkingLot.getFloors().forEach(parkingFloor -> parkingFloor.setParkingSpotList(parkingSpots));
        parkingFloorRepository.saveAll(parkingLot.getFloors());
        parkingSpotRepository.saveAll(parkingSpots);
    }
    public void markSlotBooked(ParkingSpot parkingSpot) {
        parkingSpotRepository.save(parkingSpot);
    }
}
