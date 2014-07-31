package com.hjs.study.spring.service;

import java.util.List;

import com.hjs.study.spring.bean.User;



public interface IUserService {

	/**
	 * 查询用户
	 */
	public List<User> getAllUsers();
	/**
	 * 新增用户
	 * @return
	 */
	public void createUser(User User);
	
	/**
	 * 修改用户
	 * @return
	 */
	public void editUser(User User);
	
	/**
	 * 删除用户
	 */
	public void removeUser(User User);
}
