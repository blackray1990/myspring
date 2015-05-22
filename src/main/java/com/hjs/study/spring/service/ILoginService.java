package com.hjs.study.spring.service;

import com.hjs.study.spring.bean.User;

public interface ILoginService {
	
	/**
	 * 查询用户
	 */
	public User getUser(User user);
	
}
