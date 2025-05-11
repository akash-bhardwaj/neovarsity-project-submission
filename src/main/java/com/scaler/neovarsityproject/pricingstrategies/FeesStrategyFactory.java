package com.scaler.neovarsityproject.pricingstrategies;

import com.scaler.neovarsityproject.pricingstrategies.dynamic.DynamicFeesFactory;
import com.scaler.neovarsityproject.pricingstrategies.timebased.TimeBasedFeesStrategyFactory;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeesStrategyFactory {


    private final ParkingSpotRepository parkingSpotRepository;
    public FeesCalculationFactory getFactory(String pricingScheme) {
        switch (pricingScheme) {
            case "TimeBased" -> {
                return new TimeBasedFeesStrategyFactory();
            }
            case "Dynamic" -> {
                return new DynamicFeesFactory(parkingSpotRepository);
            }
        }

        throw new RuntimeException();
    }
}
