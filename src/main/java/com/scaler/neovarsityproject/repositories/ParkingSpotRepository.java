package com.scaler.neovarsityproject.repositories;

import com.scaler.neovarsityproject.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long>  {
    List<ParkingSpot> findByVehicleTypeAndSpotStatus(VehicleType vehicleType, SpotStatus spotStatus);

    long countBySpotStatusIn(List<SpotStatus> statuses);

    ParkingSpot findBySpotId(Integer spotId);

    ParkingSpot findBySpotIdAndSpotStatus(Integer spotId, SpotStatus spotStatus);
}
