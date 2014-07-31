package com.hjs.study.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjs.study.spring.bean.User;

@Repository
public interface IUserDao {

	/**
	 * ��½��ѯ
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUserForLogin(User user);
	
	/**
	 * �����û�
	 */
	public List<User> getAllUsers();
	
	/**
	 * �޸�
	 */
	public void updateUser(User user);
	/**
	 * ����
	 */
	public void insertUser(User user);
	/**
	 * �Ƴ�
	 */
	public void deleteUser(User user);
}
