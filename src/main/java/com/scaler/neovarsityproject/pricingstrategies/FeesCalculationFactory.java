package com.scaler.neovarsityproject.pricingstrategies;

import com.scaler.neovarsityproject.models.VehicleType;

public interface FeesCalculationFactory {
    FeesStrategy getStrategy(VehicleType vehicleType);
}
