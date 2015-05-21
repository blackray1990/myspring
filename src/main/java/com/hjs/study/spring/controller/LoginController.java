package com.hjs.study.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.ext.dao.ILogonHistoryDao;
import com.hjs.study.spring.ext.model.LogonHistory;
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
	@Resource
	private ILogonHistoryDao logonHistoryDao;
	
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
		Object kaptchaTmp = request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(kaptchaTmp==null){
			return "default";
		}
		String sysKaptcha = kaptchaTmp.toString();
		if(!sysKaptcha.equalsIgnoreCase(user.getKaptcha())){
			map.addAttribute("errordtl", "��֤�����!");
			return "default";
		}
		User user1 = loginService.getUser(user);
		if(user1==null){
			map.put("msg", FAIlURE);
			return "default";
		}
		map.addAttribute("username",user1.getUserName());
		request.getSession().setAttribute("contextPaths", request.getContextPath());
		return "login/logon";
	}
	
	/**
	 * ��ת��ϵͳҳ��
	 */
	
	/**
	 * ��ȡ��¼��ʷ
	 */
	@RequestMapping(value="getlogonhistory")
	public String getLogonHistory(ModelMap model){
		List<LogonHistory> entityList = logonHistoryDao.selectLogonHistory(null);
		model.addAttribute("entityList",entityList);
		return "login/history";
	}
}
