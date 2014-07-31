package com.hjs.study.spring.bean;

public class Conversation {

	private String someone;
	
	public void sayHi(){
		System.out.println("hi "+someone+"! how are you?【Conversion是通过@Autowired注解注入】");
	}
	
	public void sayByeBye(){
		System.out.println("goodbye! "+someone);
	}

	public String getSomeone() {
		return someone;
	}

	public void setSomeone(String someone) {
		this.someone = someone;
	}
	
	
}
