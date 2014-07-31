package com.hjs.study.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjs.study.spring.bean.Battery;
import com.hjs.study.spring.bean.HelloWorld;
import com.hjs.study.spring.bean.SupResource;
import com.hjs.study.spring.bean.parent.Product;
import com.hjs.study.spring.dao.IUserDao;

public class RunTest {

	public static void main(String[] args) {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");	//ʵ����Ӧ�ó���������
		HelloWorld entity = (HelloWorld)context.getBean("HelloWorld");	//��ioc�����л�ö���
		entity.sayHello();
		entity.getCon().sayHi();
		
		Battery battery = (Battery)context.getBean("DiscountBattery");
		System.out.println(battery.getInfomation()+",����ʱ�䣺"+battery.getKeepMins()+battery.getDesc());*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//@Configration��@Beanע��ʵ��
		SupResource entity = (SupResource) context.getBean("SupResource");
		System.out.println("supresource:"+entity);
		System.out.println("name:"+entity.getName());
		System.out.println("user:"+context.getBean("tuser"));
		//@Configration��@Beanע��ʵ��
		System.exit(0);
	}
}
