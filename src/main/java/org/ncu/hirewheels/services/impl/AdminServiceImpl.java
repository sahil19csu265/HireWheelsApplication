package org.ncu.hirewheels.services.impl;

import org.ncu.hirewheels.DAO.VehicleDAO;
import org.ncu.hirewheels.entities.Vehicle;
import org.ncu.hirewheels.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private VehicleDAO vehicleDAO;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		Vehicle savedVehicle = vehicleDAO.save(vehicle);
		return savedVehicle;
	}
	
	@Override
	public Vehicle changeAvailability(long vehicleID,int status) {
		Vehicle vehicle = vehicleDAO.getReferenceById(vehicleID);
		vehicle.setAvailabilityStatus(status);
		vehicleDAO.save(vehicle);
		return vehicle;
	}
}
