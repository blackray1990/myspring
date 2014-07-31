package com.hjs.study.spring.bean;

import com.hjs.study.spring.bean.parent.Product;

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
