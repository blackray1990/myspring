package com.hjs.study.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("SupResource")
public class SupResource {

	@Value(value = "#{systemEnvironment['Path']}")	
	//systemEnvironmentΪ�����������ϣ�ͨ������['Path']���Path����ֵ
	private String name ;
	
	public String getName() {
		System.out.println("get");
		return name;
	}

	public void setName(String name) {
		System.out.println("set");
		this.name = name;
	}

	@Bean	//bean������Ϊ'tuser'����ע��User��ʵ��
	public User tuser() {
		return new User();
	}
}
