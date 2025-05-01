package com.scaler.neovarsityproject.pricingstrategies.timebased;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

import java.time.Duration;

public class SmallVehicleTimeBasedFeesStrategy implements FeesStrategy {
    /*
    50 Rupees per hour for Small Vehicles
     */
    @Override
    public int calculateFees(TicketDetails ticketDetails) {
        return (int) ((Duration.between(ticketDetails.getEntryTime(), ticketDetails.getExitTime()).toHours()) * 50);
    }
}
