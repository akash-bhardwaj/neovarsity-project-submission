package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import com.scaler.neovarsityproject.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ExitGateService {
    private final ParkingSpotRepository parkingSpotRepository;

    private final TicketRepository ticketRepository;

    public void vacateVehicleSlot(Long ticketId) throws BadRequestException {
        Optional<TicketDetails> ticketDetails = ticketRepository.findById(ticketId);
        ParkingSpot parkingSpot = ticketDetails
                .map(TicketDetails::getSpotNumber)
                .map(spotId -> parkingSpotRepository
                        .findBySpotIdAndSpotStatus(spotId,  SpotStatus.FILLED))
                .orElse(null);

        if (parkingSpot == null) {
            throw new BadRequestException("Invalid Ticket Id");
        }

        parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
        parkingSpotRepository.save(parkingSpot);
    }
}
