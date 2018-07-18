package com.main.hibernate.AbhiDD;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MetaData {

	@Id
	private int id;
	private String name;
	private String address;
	public MetaData(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
	
}
