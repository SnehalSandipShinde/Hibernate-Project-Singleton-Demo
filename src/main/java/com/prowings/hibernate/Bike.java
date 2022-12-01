package com.prowings.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bikeId;
	
	@Column(name = "name")
	String bikeName;
	
	@Column(name = "price")
	float bikePrice;

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public float getBikePrice() {
		return bikePrice;
	}

	public void setBikePrice(int bikePrice) {
		this.bikePrice = bikePrice;
	}

	public Bike(String bikeName, float bikePrice) {
		super();
		this.bikeName = bikeName;
		this.bikePrice = bikePrice;
	}
	
	

}
