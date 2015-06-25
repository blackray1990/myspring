package com.hjs.study.spring.chat;

import org.springframework.context.ApplicationEvent;

/**
 * 
 * 继承ApplicationEvent，构造参数用于传递发送过来的消息。
 * 这个事件需要一个监听器监听，一旦触发了这个事件，就可以向客户端发送消息。
 * @author Administrator
 *
 */
public class ChatMessageEvent extends ApplicationEvent{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatMessageEvent(Object source) {
		super(source);
	}
}
