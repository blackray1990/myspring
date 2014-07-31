package com.hjs.study.spring.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.dao.IUserDao;
import com.hjs.study.spring.service.IUserService;

import javax.annotation.*;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	private IUserDao userDao;
	public List<User> getAllUsers() {
		List<User> userList = userDao.getAllUsers();
		return userList;
	}

	public void createUser(User user) {
		userDao.insertUser(user);
	}

	public void editUser(User user) {
		userDao.updateUser(user);
	}

	public void removeUser(User user) {
		userDao.deleteUser(user);
	}

}
