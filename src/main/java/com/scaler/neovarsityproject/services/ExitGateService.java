package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;

public class ExitGateService {
    private final ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public void vacateVehicleSlot(TicketDetails ticketDetails) {
        ParkingSpot parkingSpot = parkingSpotRepository.findParkingSpotByTicketDetails(ticketDetails);
        parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
        parkingSpotRepository.save(parkingSpot);
    }
}
