package com.hjs.study.spring.bean;

public class Conversation {

	private String someone;
	
	public void sayHi(){
		System.out.println("hi "+someone+"! how are you?��Conversion��ͨ��@Autowiredע��ע�롿");
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
