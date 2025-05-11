package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import com.scaler.neovarsityproject.repositories.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class ExitGateService {
    private final ParkingSpotRepository parkingSpotRepository;

    private final TicketRepository ticketRepository = new TicketRepository();

    public ExitGateService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public void vacateVehicleSlot(String ticketId) {
        TicketDetails ticketDetails = ticketRepository.getTicketDetailsFromTicketId(ticketId);
        ParkingSpot parkingSpot = parkingSpotRepository.findBySpotId(ticketDetails.getSpotNumber());
        parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
        parkingSpotRepository.save(parkingSpot);
    }
}
