package com.hjs.study.spring.aspect;

import com.hjs.study.spring.bean.Article;

public class LogAspect {

	public void signBeforeM(){
		System.out.println("在方法前");
	}
	public void signAfterM(){
		System.out.println("在方法后");
	}
	
	/**
	 * 拦截新建或修改内容时
	 * 处理特殊字符、标签等
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
