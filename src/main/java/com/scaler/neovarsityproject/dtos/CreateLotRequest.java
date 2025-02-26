package com.scaler.neovarsityproject.dtos;

import com.scaler.neovarsityproject.models.*;
import lombok.Builder;
import lombok.Getter;

import java.util.*;

@Getter
@Builder
public class CreateLotRequest {

    private Long id;
    private String name;
    private String address;
    private int numberOfFloors;
    private int numberOfSlotsPerFloor;
    private int numberOfGates;


    public ParkingLot toParkingLot() {
        int min = 1;
        int max = 9000;

        List<ParkingSpot> parkingSpotsPerFloor = Collections.nCopies(
                numberOfSlotsPerFloor,
                ParkingSpot.spotAvailableForMediumVehicle());

        parkingSpotsPerFloor.forEach(parkingSpot -> parkingSpot.setSpotId((int) (Math.random() * (max - min + 1)) + min));

        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors, ParkingFloor
                        .builder()
                        .parkingSpotList(parkingSpotsPerFloor)
                        .paymentCounter(PaymentCounter.builder().build()).build());


        return ParkingLot
                .builder()
                .id(id)
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates((List<ParkingFloor>) Collections.nCopies(numberOfGates, EntryGate.builder().build()))
                .exitGates((List<ParkingFloor>) Collections.nCopies(numberOfGates, ExitGate.builder().build()))
                .build();

    }
}
