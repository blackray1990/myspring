package com.hjs.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
public class ChatController {

	@RequestMapping("chatRoom")
	public String chatRoom(HttpServletRequest request){
		System.out.println("come here");
		return "chat/chat";
	}
}
