package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.TicketDetails;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private List<TicketDetails> ticketDetailsList = new ArrayList<>();

    public TicketDetails save (TicketDetails ticketDetails) {
        ticketDetailsList.add(ticketDetails);
        return ticketDetails;
    }

}
