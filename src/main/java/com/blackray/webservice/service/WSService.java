package com.blackray.webservice.service;

import javax.xml.ws.Endpoint;

public class WSService {
    public static void main(String[] args) {
              System.out.println("web service start");
              HelloWorldService implementor= new HelloWorldServiceImpl();	//服务实现类
              String address="http://localhost:8080/helloWorld";	//供外部访问的wsdl地址?wsdl
              Endpoint.publish(address, implementor);				//发布服务
              System.out.println("web service started");
     }
}
