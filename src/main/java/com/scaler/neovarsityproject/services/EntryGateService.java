package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.dtos.GetTicketDTO;
import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.models.VehicleType;

public class EntryGateService {
    ParkingSpotService parkingSpotService = new ParkingSpotService();
    SlotAllocationService slotAllocationService = new SlotAllocationService();
    TicketService ticketService = new TicketService();


    public GetTicketDTO createTicket(VehicleType vehicleType) {
        ParkingSpot parkingSpot = slotAllocationService.allocateSlotBasedOnVehicleType(vehicleType);

        //If no slot available, return from here only.
        if (parkingSpot == null) {
            throw new RuntimeException("No Slot Available for Parking");
        }

        //Update parking spot
        parkingSpot.setSpotStatus(SpotStatus.FILLED);
        parkingSpotService.markSlotBooked(parkingSpot);

        //Create and persist ticket
        TicketDetails ticketDetails = ticketService.createTicket(vehicleType, parkingSpot);
        return GetTicketDTO.builder()
                .entryTime(ticketDetails.getEntryTime())
                .vehicleType(ticketDetails.getVehicleType())
                .build();

    }
}
