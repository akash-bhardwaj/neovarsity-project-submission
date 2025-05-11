package com.scaler.neovarsityproject.pricingstrategies.dynamic;

import com.scaler.neovarsityproject.models.SpotStatus;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

@AllArgsConstructor
public class MediumVehicleDynamicStrategy implements FeesStrategy {

    private final ParkingSpotRepository parkingSpotRepository;

    @Override
    public int calculateFees(TicketDetails ticketDetails) {
        double baseRate = 75;

        // Step 2: Calculate parked duration (in full hours, round up)
        long minutes = ChronoUnit.MINUTES.between(ticketDetails.getEntryTime(), ticketDetails.getExitTime());
        long hours = (minutes + 59) / 60;  // ceil rounding

        // Step 3: Calculate occupancy percentage
        double multiplier = getMultiplierBasedOnOccupancyRate();

        // Step 4: Calculate total fare
        return (int) (baseRate * hours * multiplier);
    }

    private double getMultiplierBasedOnOccupancyRate() {
        double occupancyRate = (parkingSpotRepository.countBySpotStatusIn(Arrays.asList(SpotStatus.FILLED,
                SpotStatus.OUT_OF_SERVICE)) * 100.0) / 9000;

        double multiplier;
        if (occupancyRate < 50) {
            multiplier = 1.0;
        } else if (occupancyRate <= 80) {
            multiplier = 1.25;
        } else {
            multiplier = 1.5;
        }
        return multiplier;
    }
}
