package com.scaler.neovarsityproject.pricingstrategies.dynamic;

import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.pricingstrategies.FeesCalculationFactory;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;
import com.scaler.neovarsityproject.pricingstrategies.timebased.SmallVehicleTimeStrategy;

public class DynamicFeesFactory implements FeesCalculationFactory {
    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        switch (vehicleType) {
            case SMALL :
                return new SmallVehicleTimeStrategy();
            case LARGE:
            case MEDIUM:
                throw new RuntimeException("Not Implemented");
        }

        throw new RuntimeException("Invalid Type");
    }
}
