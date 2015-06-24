package com.hjs.study.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.ext.dao.ILogonHistoryDao;
import com.hjs.study.spring.ext.model.LogonHistory;
import com.hjs.study.spring.service.ILoginService;
import com.hjs.study.spring.util.Constants;
import com.hjs.study.spring.util.StringUtil;

/**
 * 登陆控制器
 * @author Administrator
 *
 */
@Controller
public class LoginController extends BaseController{

	@Resource
	private ILoginService loginService;
	@Resource
	private ILogonHistoryDao logonHistoryDao;
	
	/**
	 * 登陆验证
	 * @param request
	 * @param map
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="logonsys")
	public String logonSys(HttpServletRequest request,HttpServletResponse response,ModelMap map,@ModelAttribute User user) throws Exception{
		
		String sessionId = request.getAttribute(Constants.JSESSIONID).toString();
		if(Constants.RESULT_MSG.equals(request.getAttribute(Constants.CHECK_RESULT))){
			request.getSession().setAttribute("contextPaths", request.getContextPath());
			map.addAttribute("username",request.getSession().getAttribute(sessionId));
			return "login/logon";
		}
		if(user==null){
			map.addAttribute("errordtl", "登录超时，请重新登录!");
			return "default";
		}
		Object kaptchaTmp = request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(kaptchaTmp==null){
			return "default";
		}
		String sysKaptcha = kaptchaTmp.toString();
		if(!sysKaptcha.equalsIgnoreCase(user.getKaptcha())){
			map.addAttribute("errordtl","验证码错误!");
			return "default";
		}
		User user1 = loginService.getUser(user);
		if(user1==null){
			map.put("msg", FAIlURE);
			return "default";
		}
		map.addAttribute("username",user1.getUserName());
		request.getSession().setAttribute("contextPaths", request.getContextPath());
		request.getSession().setAttribute(sessionId, user1.getUserName());
		return "login/logon";
	}

	/**
	 * 退出登录 清除session
	 */
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request){
//		String sessionId = getJSESSIONID(request);
//		request.getSession().removeAttribute(sessionId);
		return "default";
	}
	
	/**
	 * 读取登录历史
	 */
	@RequestMapping(value="gethistory")
	public String getLogonHistory(ModelMap model){
		List<LogonHistory> entityList = logonHistoryDao.selectLogonHistory(null);
		model.addAttribute("entityList",entityList);
		return "login/history";
	}
	
	
}
