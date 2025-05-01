package com.scaler.neovarsityproject.controllers;

import com.scaler.neovarsityproject.dtos.CreateLotRequest;
import com.scaler.neovarsityproject.models.ParkingLot;
import com.scaler.neovarsityproject.services.ParkingLotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {
    private ParkingLotService parkingLotService;


    @PostMapping
    public ResponseEntity<ParkingLot> createParkingLot(@Valid @RequestBody CreateLotRequest createLotRequest) {
        validate(createLotRequest);
        ParkingLot parkingLot = parkingLotService.createParkingLot(createLotRequest.toParkingLot());
        return new ResponseEntity<>(parkingLot, HttpStatus.CREATED);
    }

    private void validate(CreateLotRequest createLotRequest) {
        if(createLotRequest.getId() == null) {
            throw new RuntimeException("Id can't be null");
        }
    }
}
