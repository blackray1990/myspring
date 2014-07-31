package com.hjs.study.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hjs.study.spring.bean.Article;
import com.hjs.study.spring.dao.IArticleDao;
import com.hjs.study.spring.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService{

	@Resource
	public IArticleDao articleDao;

	public String saveNewBasicArticle(Article article) {
		articleDao.saveNewBasicArticle(article);
		return null;
	}

	public String saveEditBasicArticle(Article article) {
		articleDao.saveEditBasicArticle(article);
		return null;
	}

	public List<Article> getBasicArticles(Article article) {
		List<Article> artList = articleDao.queryBasicArticle(article);
		return artList;
	}

}
