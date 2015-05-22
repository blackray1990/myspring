package com.hjs.study.spring.test.model;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class DiscountFactoryBean extends AbstractFactoryBean{

	public Product product;
	public double discount;
	
	public DiscountFactoryBean() {

	}

	public DiscountFactoryBean(Product product,double discount) {
		this.product = product;
		this.discount = discount;
	}

	@Override
	protected Object createInstance() throws Exception {
		product.setPrice(product.getPrice()*(1-discount));
		product.setDesc("��ͨ��bean��ʽ������á�");
		return product;
	}

	@Override
	public Class getObjectType() {
		return product==null?null:product.getClass();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
}
