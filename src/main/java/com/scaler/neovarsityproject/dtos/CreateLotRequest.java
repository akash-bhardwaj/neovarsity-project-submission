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


    public ParkingLot populateParkingLotWithFloorsAndSlots() {

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for (int floorNumber = 1; floorNumber <= numberOfFloors; floorNumber++) {
            List<ParkingSpot> parkingSpotPerFloor = new ArrayList<>();

            for (int spotNumber = 1; spotNumber <= numberOfSlotsPerFloor; spotNumber++) {
                ParkingSpot parkingSpot = ParkingSpot.builder()
                        .vehicleType(VehicleType.MEDIUM)
                        .spotStatus(SpotStatus.AVAILABLE)
                        .spotId(generateRandomSpotId())
                        .floorNumber(floorNumber)
                        .build();

                parkingSpotPerFloor.add(parkingSpot);
            }

            ParkingFloor parkingFloor = ParkingFloor.builder().floorNumber(floorNumber).name("Floor " + floorNumber)
                    .parkingSpotList(parkingSpotPerFloor).paymentCounter(PaymentCounter.builder().build()).build();

            for (ParkingSpot parkingSpot : parkingSpotPerFloor) {
                parkingSpot.setFloor(parkingFloor);
            }
            parkingFloors.add(parkingFloor);
        }

        List<EntryGate> entryGates = new ArrayList<>();
        List<ExitGate> exitGates = new ArrayList<>();

        for (int i = 0; i < numberOfGates; i++) {
            entryGates.add(EntryGate.builder().build());
            exitGates.add(ExitGate.builder().build());
        }


        return ParkingLot
                .builder()
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(entryGates)
                .exitGates(exitGates)
                .build();

    }

    private int generateRandomSpotId() {
        int min = 1, max = 9000;
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
