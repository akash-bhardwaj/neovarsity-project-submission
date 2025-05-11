package com.scaler.neovarsityproject.services;

import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategyFactory;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeeCalculatorService {

    FeesStrategyFactory feesStrategyFactory;

    public int calculateFees(TicketDetails ticketDetails) {
        String PRICING_SCHEME = "TimeBased";
        FeesStrategy feesStrategy = feesStrategyFactory
                .getFactory(PRICING_SCHEME)
                .getStrategy(ticketDetails.getVehicleType());

        return feesStrategy.calculateFees(ticketDetails);
    }

}
