package com.scaler.neovarsityproject.pricingstrategies;

import com.scaler.neovarsityproject.pricingstrategies.dynamic.DynamicFeesFactory;
import com.scaler.neovarsityproject.pricingstrategies.timebased.TimeBasedFeesStrategyFactory;

public class FeesStrategyFactory {

    public static FeesCalculationFactory getFactory(String pricingScheme) {
        switch (pricingScheme) {
            case "TimeBased" -> {
                return new TimeBasedFeesStrategyFactory();
            }
            case "Dynamic" -> {
                return new DynamicFeesFactory();
            }
        }

        throw new RuntimeException();
    }
}
