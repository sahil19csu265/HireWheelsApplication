package org.ncu.hirewheels.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="vehicle")
public class Vehicle {

	@Id @Column(name="vehicle_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Size(max=10)
	private long id;
	
	@Column(name="vehicle_model",nullable=false) @NotNull
	private String model;
	
	@Column(name="vehicle_number",nullable=false) @NotNull
	private String number;
	
	@ManyToOne
	private VehicleSubCategory subcategory;
	
	@Column(name="color",nullable=false) @NotNull
	private String color;
	
	@ManyToOne
	private Location location;
	
	@ManyToOne
	private FuelType fuelType;
	
	@Column(name="avaibility_status",nullable=false) @NotNull @Min(value=0) @Max(value=1)
	private int availabilityStatus;
	
	@Column(name="vehicle_image_url",nullable=false) @NotNull
	private String imageURL;
	
	@OneToMany(mappedBy="vehicle",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Booking> bookings;
	
	public Vehicle() {
		
	}

	public Vehicle(@NotNull String model, @NotNull String number, VehicleSubCategory subcategory, @NotNull String color,
			Location location, FuelType fuelType, @NotNull @Min(0) @Max(1) int availabilityStatus,
			@NotNull String imageURL) {
		this.model = model;
		this.number = number;
		this.subcategory = subcategory;
		this.color = color;
		this.location = location;
		this.fuelType = fuelType;
		this.availabilityStatus = availabilityStatus;
		this.imageURL = imageURL;
	}

	public Vehicle(@NotNull String model, @NotNull String number, @NotNull String color,
			@NotNull @Min(0) @Max(1) int availabilityStatus, @NotNull String imageURL) {
		this.model = model;
		this.number = number;
		this.color = color;
		this.availabilityStatus = availabilityStatus;
		this.imageURL = imageURL;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public VehicleSubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(VehicleSubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public int getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(int availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", number=" + number + ", subcategory=" + subcategory
				+ ", color=" + color + ", location=" + location + ", fuelType=" + fuelType + ", availabilityStatus="
				+ availabilityStatus + ", imageURL=" + imageURL + ", bookings=" + bookings + "]";
	}
	
}
