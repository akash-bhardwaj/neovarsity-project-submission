package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.repositories.TicketRepository;

import java.time.LocalDateTime;

public class TicketService {

    private TicketRepository ticketRepository = new TicketRepository();

    public TicketDetails createTicket(VehicleType vehicleType, ParkingSpot parkingSpot) {

        TicketDetails ticketDetails = TicketDetails
                .builder()
                .entryTime(LocalDateTime.now())
                .floorNumber(parkingSpot.getFloorNumber())
                .slotNumber(parkingSpot.getSpotId())
                .build();

        return ticketRepository.save(ticketDetails);
    }
}
