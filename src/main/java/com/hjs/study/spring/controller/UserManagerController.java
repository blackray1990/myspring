package com.hjs.study.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjs.study.spring.bean.Menu;
import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.service.IMenuService;
import com.hjs.study.spring.service.IUserService;

/**
 * �˵�������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("user")
public class UserManagerController extends BaseController{

	@Resource
	private IUserService userService;
	
	private final static String initPass = "123456";	//��ʼ������
	
	/**
	 * ���ز˵�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("queryusers")
	public String loadMenu(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		
		List<User> userList = userService.getAllUsers();
		map.put("data", userList);
		return "user/userList";
	}
	
	/**
	 * ��ʼ������
	 */
	@RequestMapping("initordelete")
	@ResponseBody
	public String initOrDeleteUser(HttpServletRequest request,User user){
		String option = request.getParameter("option");
		if("init".equals(option)){
			user.setPassword(initPass);		//�������޸ĺ��ֵ
			userService.editUser(user);
		}
		if("delete".equals(option)){
			userService.removeUser(user);
		}
		return SUCCESS;
	}
	
	/**
	 * �������޸�
	 */
	@RequestMapping("operation")
	@ResponseBody
	public String operateUser(HttpServletRequest request,User user){
		user.setPassword(initPass);
		userService.createUser(user);
		return SUCCESS;
	}
}
