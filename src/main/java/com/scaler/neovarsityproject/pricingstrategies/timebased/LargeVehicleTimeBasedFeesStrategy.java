package com.scaler.neovarsityproject.pricingstrategies.timebased;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

import java.time.Duration;

public class LargeVehicleTimeBasedFeesStrategy implements FeesStrategy {
    /*
    100 Rupees per hour for Large Vehicles
     */
    @Override
    public int calculateFees(TicketDetails ticketDetails) {
        return (int) ((Duration.between(ticketDetails.getEntryTime(), ticketDetails.getExitTime()).toHours()) * 100);
    }
}
