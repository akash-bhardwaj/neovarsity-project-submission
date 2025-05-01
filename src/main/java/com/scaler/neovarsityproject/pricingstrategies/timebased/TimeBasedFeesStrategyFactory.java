package com.scaler.neovarsityproject.pricingstrategies.timebased;

import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.pricingstrategies.FeesCalculationFactory;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

public class TimeBasedFeesStrategyFactory implements FeesCalculationFactory {

    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case SMALL -> new SmallVehicleTimeBasedFeesStrategy();
            case MEDIUM -> new MediumVehicleTimeBasedFeesStrategy();
            case LARGE -> new LargeVehicleTimeBasedFeesStrategy();
        };

    }
}
