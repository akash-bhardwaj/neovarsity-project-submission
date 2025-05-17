package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.ParkingSpot;
import com.scaler.neovarsityproject.models.TicketDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketDetails, Long> {
}
