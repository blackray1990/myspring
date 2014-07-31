package com.hjs.study.spring.service.impl;

import org.springframework.stereotype.Service;

import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.dao.IUserDao;
import com.hjs.study.spring.service.ILoginService;
import javax.annotation.*;

@Service
public class LoginServiceImpl implements ILoginService{

	public LoginServiceImpl(){}
	
	@Resource
	private IUserDao userDao;
	
	public User getUser(User user) {
		User loginUser = userDao.getUserForLogin(user);
		return loginUser;
	}
}
