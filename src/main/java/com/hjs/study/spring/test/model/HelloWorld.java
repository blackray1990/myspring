package com.hjs.study.spring.test.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {

	/**
	 * iocע��
	 */
	public String firstName;
	public String secondName;		//��ͨ����
	public List<Object> companys;	//���ϱ���
	public Set<Object> belover;
	public Map<String,Object> myself;
	
	@Autowired		//ʹ��Autowired�Զ�װ������� ��byType����ȸ����
	public Conversation con ;
	
	public int counter;
	
	
	
	public HelloWorld() {
		super();
	}

	public HelloWorld(String firstName, String secondName,Conversation con) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.con = con;
	}

	public synchronized void sayHello(){
		
		System.out.println("��ã�"+firstName+" "+secondName);
		
		for (Object obj : companys) {
			
			if(obj instanceof Properties){		//�ж��Ƿ����ڴ����Ͷ���
				Properties temp = (Properties)obj;
				for (Object prop : temp.entrySet()) {
					System.out.println("���µĹ�˾��"+prop);
				}
			}else{
				System.out.println("���µĹ�˾��"+obj);
			}
		}
		for (Object obj : belover) {
				System.out.println("�����ˣ�"+obj);
		}
		for (Object obj : myself.entrySet()) {
			System.out.println("�Լ���"+obj);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @Required ��ʾ�����Ա������ã�ʹ��ע�⣬�����ļ��б������<context:annotation-config />
	 * ���û�����ý��׳�����
	 * @param firstName
	 */
	@Required		
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public List<Object> getCompanys() {
		return companys;
	}

	public void setCompanys(List<Object> companys) {
		this.companys = companys;
	}
	public Set<Object> getBelover() {
		return belover;
	}

	public void setBelover(Set<Object> belover) {
		this.belover = belover;
	}

	public Map<String, Object> getMyself() {
		return myself;
	}

	public void setMyself(Map<String, Object> myself) {
		this.myself = myself;
	}

	public Conversation getCon() {
		return con;
	}

	public void setCon(Conversation con) {
		this.con = con;
	}
	
}
