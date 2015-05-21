package com.blackray.webservice.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.blackray.webservice.model.Person;
import com.blackray.webservice.service.HelloWorldService;

public class WSClientForSpring {
    public static void main(String[] args) {
              JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
              svr.setServiceClass(HelloWorldService.class);			//设置服务类class
              svr.setAddress("http://localhost:8080/myspring/remote/HelloWorld");	//访问集成在spring中的wsdl地址
              
              HelloWorldService hw = (HelloWorldService) svr.create();	//获得服务类实例
              
              System.out.println(hw.sayHi("Hejinsheng"));	//调用服务
              
              Person person = new Person();
              person.setName("Tony");
              person.setDescription("test");
              System.out.println(hw.sayHiToUser(person));	//调用服务
    }
}
