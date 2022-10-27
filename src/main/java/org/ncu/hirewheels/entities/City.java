package org.ncu.hirewheels.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="city")
public class City {

	@Id @Column(name="city_id")
	private long id;
	
	@Column(name="city_name",nullable=false) @NotNull
	private String name;
	
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	Set<Location> locations;
	
	public City() {
		
	}
	
	public City(long id,@NotNull String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", locations=" + locations + "]";
	}

	
}
