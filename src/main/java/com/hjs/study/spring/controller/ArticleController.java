package com.hjs.study.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjs.study.spring.bean.Article;
import com.hjs.study.spring.service.IArticleService;

@Controller
@RequestMapping("article")
public class ArticleController extends BaseController{
	
	@Resource
	public IArticleService articleService;

	
	/**
	 *  进入菜单
	 */
	@RequestMapping("common")
	public String basicKnowledge(HttpServletRequest request,Article article,ModelMap map){
		List<Article> artList = articleService.getBasicArticles(article);
		if(artList!=null&&artList.size()>0){
			map.put("article", artList.get(0));
		}else{
			map.put("title", request.getParameter("title"));
		}
		return "article/common_page";
	}
	
	@RequestMapping("createArticle")
	@ResponseBody
	public String createArticle(HttpServletRequest request,Article article){
		articleService.saveNewBasicArticle(article);
		return "success";
	}
	
	@RequestMapping("editArticle")
	@ResponseBody
	public String editArticle(HttpServletRequest request,Article article){
		
		articleService.saveEditBasicArticle(article);
		return "success";
	}
}
