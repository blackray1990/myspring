package com.hjs.study.spring.service;

import java.util.List;

import com.hjs.study.spring.bean.User;



public interface IUserService {

	/**
	 * ��ѯ�û�
	 */
	public List<User> getAllUsers();
	/**
	 * �����û�
	 * @return
	 */
	public void createUser(User User);
	
	/**
	 * �޸��û�
	 * @return
	 */
	public void editUser(User User);
	
	/**
	 * ɾ���û�
	 */
	public void removeUser(User User);
}
