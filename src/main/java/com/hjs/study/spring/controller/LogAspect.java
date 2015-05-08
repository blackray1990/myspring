package com.hjs.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import com.hjs.study.spring.bean.Article;

public class LogAspect {

	public void signBeforeM(){
		System.out.println("�ڷ���ǰ");
	}
	public void signAfterM(){
		System.out.println("�ڷ�����");
	}
	
	/**
	 * �����½����޸�����ʱ
	 * ���������ַ�����ǩ��
	 * @param article
	 */
	public void handleContent(Article article){
		String temp = article.getContent();
		if(temp!=null){
			temp = temp.replaceAll("\n", "<br>");
			article.setContent(temp);
		}
	}
}
