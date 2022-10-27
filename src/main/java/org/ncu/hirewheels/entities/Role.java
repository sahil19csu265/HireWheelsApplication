package org.ncu.hirewheels.entities;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="role")
public class Role {

	@Id @Column(name="role_id") @Size(max=10)
	private long id;
	
	@Column(name="role_name",nullable=false,unique=true) @NotNull
	private String name;
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<User> users;
	
	public Role() {
		
	}
	
	public Role(String name) {
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
}
