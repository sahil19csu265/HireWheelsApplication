package org.ncu.hirewheels.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="fuel_type")
public class FuelType {

	@Id @Column(name="fuel_type_id") @GeneratedValue(strategy=GenerationType.IDENTITY) @Size(max=10)
	private long id;
	
	@Column(name="fuel_type",nullable=false,unique=true) @NotNull
	private String type;
	
	@OneToMany(mappedBy="fuelType",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Vehicle> vehicles;
	
	public FuelType() {
		
	}

	public FuelType(@NotNull String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FuelType [id=" + id + ", type=" + type + "]";
	}
	
}
