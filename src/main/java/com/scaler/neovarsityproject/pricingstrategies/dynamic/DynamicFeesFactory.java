package com.scaler.neovarsityproject.pricingstrategies.dynamic;

import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.pricingstrategies.FeesCalculationFactory;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;

public class DynamicFeesFactory implements FeesCalculationFactory {
    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case SMALL -> new SmallVehicleDynamicStrategy();
            case MEDIUM -> new MediumVehicleDynamicStrategy();
            case LARGE -> new LargeVehicleDynamicStrategy();
        };

    }
}
