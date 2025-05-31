package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    public TicketDetails createTicket(VehicleType vehicleType, ParkingSpot parkingSpot) {

        TicketDetails ticketDetails = TicketDetails
                .builder()
                .entryTime(LocalDateTime.now())
                .floorNumber(parkingSpot.getFloorNumber())
                .spotNumber(parkingSpot.getSpotId())
                .ticketId(String.valueOf((int)(Math.random() * 100000)))
                .vehicleType(vehicleType)
                .build();

        return ticketRepository.save(ticketDetails);
    }
}
