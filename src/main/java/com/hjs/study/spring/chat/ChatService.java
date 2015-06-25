package com.hjs.study.spring.chat;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
 
/**
 * 发送消息服务类，用户客户端发送消息。dwr需要暴露这个类里面的发送消息的方法
 */
@Component
public class ChatService implements ApplicationContextAware {
    private ApplicationContext ctx;
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    
    /**
     * 向服务器发送信息，服务器端监听ChatMessageEvent事件，当有事件触发就向所有客户端发送信息
     */
    public void sendMessage(Message msg) {
        //发布事件
        ctx.publishEvent(new ChatMessageEvent(msg));
    }
    public ChatService() {
		System.out.println("构造方法");
	}
}
