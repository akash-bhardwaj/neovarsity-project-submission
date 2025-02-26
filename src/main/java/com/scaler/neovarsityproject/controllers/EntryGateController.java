package com.scaler.neovarsityproject.controllers;

import com.scaler.neovarsityproject.dtos.GetTicketDTO;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.services.EntryGateService;

public class EntryGateController {
    EntryGateService entryGateService = new EntryGateService();

    public GetTicketDTO createTicket(VehicleType vehicleType){
        return entryGateService.createTicket(vehicleType);
    }
}
