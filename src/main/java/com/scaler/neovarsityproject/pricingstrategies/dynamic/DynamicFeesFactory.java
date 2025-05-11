package com.scaler.neovarsityproject.pricingstrategies.dynamic;

import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.pricingstrategies.FeesCalculationFactory;
import com.scaler.neovarsityproject.pricingstrategies.FeesStrategy;
import com.scaler.neovarsityproject.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DynamicFeesFactory implements FeesCalculationFactory {

    private final ParkingSpotRepository parkingSpotRepository;
    @Override
    public FeesStrategy getStrategy(VehicleType vehicleType) {
        return switch (vehicleType) {
            case SMALL -> new SmallVehicleDynamicStrategy(parkingSpotRepository);
            case MEDIUM -> new MediumVehicleDynamicStrategy(parkingSpotRepository);
            case LARGE -> new LargeVehicleDynamicStrategy(parkingSpotRepository);
        };
    }
}
