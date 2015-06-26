package com.hjs.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
public class ChatController {

	/**
	 * 跳转到聊天界面
	 * @param request
	 * @return
	 */
	@RequestMapping("chatRoom")
	public String chatRoom(HttpServletRequest request){

		return "chat/chat";
	}
}
