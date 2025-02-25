package com.scaler.neovarsityproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TicketDetails extends BaseModel {
    private String ticketId;
    private String vehicleId;
    private VehicleType vehicleType;
    private Integer floorNumber;
    private Integer slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
}
