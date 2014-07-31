package com.hjs.study.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("SupResource")
public class SupResource {

	@Value(value = "#{systemEnvironment['Path']}")	
	//systemEnvironment为环境变量集合，通过索引['Path']获得Path变量值
	private String name ;
	
	public String getName() {
		System.out.println("get");
		return name;
	}

	public void setName(String name) {
		System.out.println("set");
		this.name = name;
	}

	@Bean	//bean的名称为'tuser'，被注入User的实例
	public User tuser() {
		return new User();
	}
}
