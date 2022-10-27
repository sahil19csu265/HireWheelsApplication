package org.ncu.hirewheels.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="vehicle_category")
public class VehicleCategory {

	@Id @Column(name="vehicle_category_id") @GeneratedValue(strategy=GenerationType.AUTO) @Size(max=10)
	private long id;
	
	@Column(name="vehicle_category_name",nullable=false,unique=true) @NotNull
	private String name;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<VehicleSubCategory> subCategory;
	
	public VehicleCategory() {
		
	}

	public VehicleCategory(@NotNull String name) {
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

	public Set<VehicleSubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Set<VehicleSubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "VehicleCategory [id=" + id + ", name=" + name + ", subCategory=" + subCategory + "]";
	}
	
}
