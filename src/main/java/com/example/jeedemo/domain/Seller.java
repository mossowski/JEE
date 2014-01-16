package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
<<<<<<< HEAD
@NamedQuery(name = "seller.all", query = "Select se from Seller se")

=======
@NamedQuery(name = "seller.removed", query = "Select se from Seller se where se.removed = false")
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
public class Seller {
	
	private Long id;
	private String firstName;
	private String lastName;
<<<<<<< HEAD

=======
	private Boolean removed = false;
	
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
<<<<<<< HEAD
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
=======
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getRemoved() {
		return removed;
	}
	public void setRemoved(Boolean removed) {
		this.removed = removed;
	}
>>>>>>> c8f944735c8885c53dfbc33f62636dba43e98556
	
	
}
