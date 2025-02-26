package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingLot;
import com.scaler.neovarsityproject.repositories.ParkingLotRepository;

public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        ParkingLot lot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createSpots(parkingLot);
        return lot;
    }

}
