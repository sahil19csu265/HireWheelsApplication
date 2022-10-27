package org.ncu.hirewheels.DAO;

import org.ncu.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<Vehicle,Long> {

}
