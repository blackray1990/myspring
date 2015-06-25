package com.hjs.study.spring.chat;

import java.util.Date;
/**
 * 消息实体类
 * @author Administrator
 *
 */
public class Message {
	
	private int id;
	
    private String msg;
    
    private Date time;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
