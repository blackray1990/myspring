package com.hjs.study.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjs.study.spring.bean.Menu;
import com.hjs.study.spring.service.IMenuService;

/**
 * 菜单控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("menu")
public class MenusLoadController extends BaseController{

	@Resource
	private IMenuService menuService;
	
	/**
	 * 加载菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("loadmenu")
	@ResponseBody()
	public String loadMenu(HttpServletRequest request,HttpServletResponse response){
//		response.setContentType("text/html;charset=UTF-8");
		String content = menuService.getAllMenus();
		System.out.println(content);
//		content = "[{\"children\":[{\"children\":[],\"id\":12,\"isFolder\":0,\"parent\":15,\"parentText\":\"友情链接\",\"template\":\"article/iframe.jsp\",\"text\":\"百度\",\"url\":\"http://www.baidu.com\"}],\"id\":15,\"isFolder\":1,\"location\":0,\"parent\":0,\"parentText\":\"\",\"state\":\"closed\",\"template\":\"\",\"text\":\"友情链接\",\"url\":\"\"}]";
		return content;
	}
	
	/**
	 * 跳转至菜单页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("manager")
	public String managerMenu(HttpServletRequest request,HttpServletResponse response){
		
		return "menu/menuList";
	}
	
	/**
	 * 新增或编辑菜单
	 */
	@RequestMapping("operation")
	@ResponseBody()
	public String operatMenu(Menu menu,HttpServletRequest request){
		String operation = request.getParameter("operation");
		if("add".equals(operation)){
			menuService.createMenu(menu);
		}
		if("edit".equals(operation)){
			menuService.editMenu(menu);
		}
		if("delete".equals(operation)){
			menuService.removeMenu(menu);
		}
		return SUCCESS;
	}
}
