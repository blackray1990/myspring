package com.blackray.webservice.service;

import javax.xml.ws.Endpoint;
/**
 * Ҳ����spring������ע�� �����Ŀspring�����ļ�
 * @author Administrator
 *
 */
public class WSService {
    public static void main(String[] args) {
              System.out.println("web service start");
              HelloWorldService implementor= new HelloWorldServiceImpl();	//����ʵ����
              String address="http://localhost:8080/helloWorld";	//���ⲿ���ʵ�wsdl��ַ?wsdl
              Endpoint.publish(address, implementor);				//��������
              System.out.println("web service started");
     }
}
