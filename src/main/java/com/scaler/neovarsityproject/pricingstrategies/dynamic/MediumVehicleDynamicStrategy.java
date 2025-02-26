package com.scaler.neovarsityproject.pricingstrategies.dynamic;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

public class MediumVehicleDynamicStrategy implements FeesStrategy {
    @Override
    public int calculateFees(TicketDetails ticketDetails) {
        return 0;
    }
}
