package com.hjs.study.spring.test.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {

	/**
	 * ioc注入
	 */
	public String firstName;
	public String secondName;		//普通变量
	public List<Object> companys;	//集合变量
	public Set<Object> belover;
	public Map<String,Object> myself;
	
	@Autowired		//使用Autowired自动装配改属性 与byType等相比更灵活
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
		
		System.out.println("你好！"+firstName+" "+secondName);
		
		for (Object obj : companys) {
			
			if(obj instanceof Properties){		//判断是否属于此类型对象
				Properties temp = (Properties)obj;
				for (Object prop : temp.entrySet()) {
					System.out.println("从事的公司："+prop);
				}
			}else{
				System.out.println("从事的公司："+obj);
			}
		}
		for (Object obj : belover) {
				System.out.println("爱的人："+obj);
		}
		for (Object obj : myself.entrySet()) {
			System.out.println("自己："+obj);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @Required 表示该属性必须设置，使用注解，配置文件中必须加入<context:annotation-config />
	 * 如果没有设置将抛出错误
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
