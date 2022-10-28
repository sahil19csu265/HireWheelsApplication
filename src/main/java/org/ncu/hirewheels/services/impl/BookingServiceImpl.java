package org.ncu.hirewheels.services.impl;

import org.ncu.hirewheels.DAO.BookingDAO;
import org.ncu.hirewheels.DAO.UserDAO;
import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public Booking addBooking(Booking bookingDetails) {
		User user = userDAO.getReferenceById(bookingDetails.getUser().getId());
		if(bookingDetails.getAmount() > user.getWalletMoney()) {
			return null;
		}
		else {
			return bookingDAO.save(bookingDetails);
		}
	}
	
								
}
