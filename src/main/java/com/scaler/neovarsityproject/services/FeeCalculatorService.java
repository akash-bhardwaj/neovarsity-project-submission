package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategyFactory;

public class FeeCalculatorService {

    private static final String PRICING_SCHEME = "TimeBased";

    public int calculateFees(TicketDetails ticketDetails) {
        FeesStrategy feesStrategy = FeesStrategyFactory
                .getFactory(PRICING_SCHEME)
                .getStrategy(ticketDetails.getVehicleType());

        return feesStrategy.calculateFees(ticketDetails);
    }

}
