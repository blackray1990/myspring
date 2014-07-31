package com.hjs.study.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjs.study.spring.bean.Menu;

@Repository
public interface IMenuDao {

	/**
	 * ��ѯһ��Ŀ¼
	 */
	public List<Menu> queryMainMenus();
	
	/**
	 * ����
	 */
	public void createMenu(Menu menu);
	
	/**
	 * �޸�
	 */
	public void editMenu(Menu menu);
	/**
	 * ɾ��
	 */
	public void deleteMenu(Menu menu);
}
