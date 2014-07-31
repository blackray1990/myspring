package com.hjs.study.spring.service;

import java.util.List;

import com.hjs.study.spring.bean.Article;

public interface IArticleService {

	public String saveNewBasicArticle(Article article);
	
	public String saveEditBasicArticle(Article article);
	
	public List<Article> getBasicArticles(Article article);
}
