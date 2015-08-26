package com.hjs.study.dubbo.consumer;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unj.dubbotest.provider.DemoService;


/**
 * 消费者类
 * @author Hejinsheng
 *
 */
public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo/consumer.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("demoServicee");
		for (int i = 0; i < 100; i++) {
			String hello = demoService.sayHello("Hejinsheng");
			System.out.println(hello);
			
			Thread.sleep(1000);
		}

/*		List list = demoService.getUsers();
		
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		System.in.read();*/
	}

}