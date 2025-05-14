package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingLot;
import com.scaler.neovarsityproject.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        parkingLot.setId(null);
        parkingLotRepository.save(parkingLot);
        return parkingLot;
    }

}
