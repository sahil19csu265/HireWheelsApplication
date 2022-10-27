package org.ncu.hirewheels.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="booking")
public class Booking {

	@Id @Column(name="booking_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Size(max=10)
	private long id;
	
	@Column(name="pickup_date",nullable=false) @NotNull @Temporal(TemporalType.DATE)
	private Date pickUpDate;
	
	@Column(name="dropoff_date",nullable=false) @NotNull @Temporal(TemporalType.DATE)
	private Date dropOffDate;
	
	@Column(name="booking_date",nullable=false) @NotNull @Temporal(TemporalType.DATE)
	private Date BookingDate;
	
	@Column(name="amount",nullable=false) @NotNull
	private double amount;
	
	@ManyToOne
	private Location location;
	
	@ManyToOne
	private Vehicle vehicle;
	
	@ManyToOne 
	private User user;

	public Booking(@NotNull Date pickUpDate, @NotNull Date dropOffDate, @NotNull Date bookingDate,
			@NotNull double amount) {
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		BookingDate = bookingDate;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(Date dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public Date getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", pickUpDate=" + pickUpDate + ", dropOffDate=" + dropOffDate + ", BookingDate="
				+ BookingDate + ", amount=" + amount + ", location=" + location + ", vehicle=" + vehicle + ", user="
				+ user + "]";
	}
		
}
