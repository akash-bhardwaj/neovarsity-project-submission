package com.scaler.neovarsityproject.controllers;

import com.scaler.neovarsityproject.dtos.CreateLotRequest;
import com.scaler.neovarsityproject.models.ParkingLot;
import com.scaler.neovarsityproject.services.ParkingLotService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ParkingLotController {
    private ParkingLotService parkingLotService;


    public ParkingLot createParkingLot(CreateLotRequest createLotRequest) {
        validate(createLotRequest);
        return parkingLotService.createParkingLot(createLotRequest.toParkingLot());
    }

    private void validate(CreateLotRequest createLotRequest) {
        if(createLotRequest.getId() == null) {
            throw new RuntimeException("Id can't be null");
        }
    }
}
