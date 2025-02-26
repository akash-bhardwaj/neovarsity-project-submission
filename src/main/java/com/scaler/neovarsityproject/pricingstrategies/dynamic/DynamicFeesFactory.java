package com.scaler.neovarsityproject.pricingstrategies.dynamic;

import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.pricingstrategies.FeesCalculationFactory;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;
import com.scaler.neovarsityproject.pricingstrategies.timebased.LargeVehicleTimeStrategy;
import com.scaler.neovarsityproject.pricingstrategies.timebased.SmallVehicleTimeStrategy;

public class DynamicFeesFactory implements FeesCalculationFactory {
    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case SMALL -> new SmallVehicleDynamicStrategy();
            case LARGE -> new LargeVehicleDynamicStrategy();
            case MEDIUM -> new MediumVehicleDynamicStrategy();
        };

    }
}
