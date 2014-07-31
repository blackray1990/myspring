package com.hjs.study.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.service.ILoginService;

/**
 * ��½������
 * @author Administrator
 *
 */
@Controller
public class LoginController extends BaseController{

	@Resource
	private ILoginService loginService;
	
	/**
	 * ��½��֤
	 * @param request
	 * @param map
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="logonsys")
//	@ResponseBody
	public String logonSys(HttpServletRequest request,ModelMap map,@ModelAttribute User user) throws Exception{
		
		User user1 = loginService.getUser(user);
		if(user1==null){
			map.put("msg", FAIlURE);
			return "default";
		}
		return "login/logon";
	}
	
	/**
	 * ��ת��ϵͳҳ��
	 */
}
