package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.TicketDetails;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private final List<TicketDetails> ticketDetailsList = new ArrayList<>();

    public TicketDetails save (TicketDetails ticketDetails) {
        ticketDetailsList.add(ticketDetails);
        return ticketDetails;
    }

    public TicketDetails getTicketDetailsFromTicketId(String ticketId) {
        return ticketDetailsList.stream()
                .filter(ticketDetails -> ticketDetails.getTicketId().equals(ticketId))
                .findFirst()
                .orElse(null);
    }

}
