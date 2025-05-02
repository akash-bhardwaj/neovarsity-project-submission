package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {

    List<ParkingSpot> parkingSpotList = new ArrayList<>();

    public void save(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
    }

    public void saveAll(List<ParkingSpot> parkingSpots) {
        this.parkingSpotList.addAll(parkingSpots);
    }


    public ParkingSpot findParkingSpotByVehicleTypeAndStatusAvailable(VehicleType vehicleType) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if(parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == vehicleType) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot findParkingSpotByTicketDetails(TicketDetails ticketDetails) {
        return parkingSpotList
                .stream()
                .filter(parkingSpot -> parkingSpot.getSpotId().equals(ticketDetails.getSpotNumber()))
                .findFirst()
                .orElse(null);
    }

    public long countFilledOrOutOfServiceSpots() {
        return parkingSpotList.stream()
                .filter(spot -> spot.getSpotStatus() == SpotStatus.FILLED
                        || spot.getSpotStatus() == SpotStatus.OUT_OF_SERVICE)
                .count();
    }
}
