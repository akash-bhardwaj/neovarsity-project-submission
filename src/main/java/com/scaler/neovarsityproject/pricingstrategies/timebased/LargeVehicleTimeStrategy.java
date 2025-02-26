package com.scaler.neovarsityproject.pricingstrategies.timebased;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

public class LargeVehicleTimeStrategy implements FeesStrategy {
    @Override
    public int calculateFees(TicketDetails ticketDetails) {
        return 0;
    }
}
