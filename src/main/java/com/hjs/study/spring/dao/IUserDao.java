package com.hjs.study.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjs.study.spring.bean.User;

@Repository
public interface IUserDao {

	/**
	 * 登陆查询
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUserForLogin(User user);
	
	/**
	 * 所有用户
	 */
	public List<User> getAllUsers();
	
	/**
	 * 修改
	 */
	public void updateUser(User user);
	/**
	 * 新增
	 */
	public void insertUser(User user);
	/**
	 * 移除
	 */
	public void deleteUser(User user);
}
