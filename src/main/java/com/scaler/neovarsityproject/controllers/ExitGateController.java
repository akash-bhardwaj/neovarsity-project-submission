package com.scaler.neovarsityproject.controllers;

import com.scaler.neovarsityproject.dtos.GetTicketDTO;
import com.scaler.neovarsityproject.models.TicketDetails;
import com.scaler.neovarsityproject.models.VehicleType;
import com.scaler.neovarsityproject.services.ExitGateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/exit-gate")
public class ExitGateController {

    ExitGateService exitGateService;

    @GetMapping
    public ResponseEntity<GetTicketDTO> vacateVehicleSlot(@RequestParam @NonNull Long ticketId) throws
            BadRequestException {
       exitGateService.vacateVehicleSlot(ticketId);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
