package com.scaler.neovarsityproject.controllers;

import com.scaler.neovarsityproject.dtos.GetTicketDTO;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.services.EntryGateService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/entry-gate")
public class EntryGateController {
    EntryGateService entryGateService;

    @GetMapping
    public ResponseEntity<GetTicketDTO> createTicket(@RequestParam(defaultValue = "MEDIUM") VehicleType vehicleType)
            throws BadRequestException {
        GetTicketDTO ticket = entryGateService.createTicket(vehicleType);
        return new ResponseEntity<>(ticket, HttpStatus.ACCEPTED);
    }
}
