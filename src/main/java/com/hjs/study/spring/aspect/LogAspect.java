package com.hjs.study.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.hjs.study.spring.bean.Article;

@Component
@Aspect
public class LogAspect {

	@Before("execution(* *.getU*(..))")
	public void signBeforeM(){
		System.out.println("在方法前");
	}
	@After("execution(* *.getU*(..))")
	public void signAfterM(){
		System.out.println("在方法后");
	}
	
	/**
	 * 拦截新建或修改内容时
	 * 处理特殊字符、标签等
	 * @param article
	 */
	@Before("execution(* *.save*BasicArticle(..))&&args(article))")
	public void handleContent(Article article){
		String temp = article.getContent();
		if(temp!=null){
			temp = temp.replaceAll("\n", "<br>");
			article.setContent(temp);
		}
	}
}
