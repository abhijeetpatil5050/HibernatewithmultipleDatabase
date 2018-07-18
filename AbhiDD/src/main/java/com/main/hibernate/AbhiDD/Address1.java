package com.main.hibernate.AbhiDD;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address1 {
	
	@Id
	public int id;
	public String address;
	public Address1(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}
	
	

}
