package com.hjs.study.spring.test.model;

public class Product {

	public String brand;
	public String productName;
	public double price;
	private String desc;
	public Product(){}
	
	public Product(String brand, String productName, double price) {
		super();
		this.brand = brand;
		this.productName = productName;
		this.price = price;
	}

	public String getInfomation(){
		String info = "品牌："+brand+"，产品名："+productName+",价格："+price;
		return info;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
