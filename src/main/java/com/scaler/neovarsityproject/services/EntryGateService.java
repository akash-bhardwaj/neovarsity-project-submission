package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.dtos.GetTicketDTO;
import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.models.VehicleType;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EntryGateService {
    private ParkingSpotService parkingSpotService;
    private SlotAllocationService slotAllocationService;
    private TicketService ticketService;


    public GetTicketDTO createTicket(VehicleType vehicleType) throws BadRequestException {
        ParkingSpot parkingSpot = slotAllocationService.allocateSlotBasedOnVehicleType(vehicleType);

        //If no slot available, return from here only.
        if (parkingSpot == null) {
            throw new BadRequestException("No Slot Available for Parking");
        }

        //Update parking spot
        parkingSpot.setSpotStatus(SpotStatus.FILLED);
        parkingSpotService.persistParkingSlot(parkingSpot);

        //Create and persist ticket
        TicketDetails ticketDetails = ticketService.createTicket(vehicleType, parkingSpot);
        return GetTicketDTO.builder()
                .entryTime(ticketDetails.getEntryTime())
                .vehicleType(ticketDetails.getVehicleType())
                .build();

    }
}
