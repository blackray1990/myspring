package com.hjs.study.spring.test.model;

/**
 * 用于测试spring-data-redis 实体类
 * @author Administrator
 *
 */
public class PersonDO {

	private Integer id;
	
	private String name;
	
	private String phone;
	
	private Integer sex;
	
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
