package com.hjs.study.spring.test.model;


public class Battery extends Product{

	private double keepMins;
	

	public Battery(){}
	
	public Battery(String brand, String productName, double price) {
		this.brand = brand;
		this.productName = productName;
		this.price = price;
	}

	public double getKeepMins() {
		return keepMins;
	}

	public void setKeepMins(double keepMins) {
		this.keepMins = keepMins;
	}

}
