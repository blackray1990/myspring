package com.hjs.study.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjs.study.spring.bean.Article;

@Repository
public interface IArticleDao {

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public void saveNewBasicArticle(Article article);
	
	public void saveEditBasicArticle(Article article);
	
	/**
	 * ≤È—Ø¡–±Ì
	 * @param article
	 * @return
	 */
	public List<Article> queryBasicArticle(Article article);
}
