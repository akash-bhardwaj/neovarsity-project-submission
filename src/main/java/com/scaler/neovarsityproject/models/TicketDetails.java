package com.scaler.neovarsityproject.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
public class TicketDetails extends BaseModel {
    private String ticketId;
    private String vehicleId;
    private VehicleType vehicleType;
    private Integer floorNumber;
    private Integer spotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
}
