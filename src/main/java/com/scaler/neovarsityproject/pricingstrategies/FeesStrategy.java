package com.scaler.neovarsityproject.pricingstrategies;

import com.scaler.neovarsityproject.models.TicketDetails;

public interface FeesStrategy {
    int calculateFees(TicketDetails ticketDetails);
}
