package com.scaler.neovarsityproject.pricingstrategies.timebased;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

import java.time.Duration;

public class MediumVehicleTimeBasedFeesStrategy implements FeesStrategy {
    /*
    75 Rupees per hour for Medium Vehicles
     */
    @Override
    public int calculateFees(TicketDetails ticketDetails) {
        return (int) ((Duration.between(ticketDetails.getEntryTime(), ticketDetails.getExitTime()).toHours()) * 75);
    }
}
