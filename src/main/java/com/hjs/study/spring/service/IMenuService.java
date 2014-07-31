package com.hjs.study.spring.service;

import com.hjs.study.spring.bean.Menu;



public interface IMenuService {

	/**
	 * ��ѯ�˵�
	 */
	public String getAllMenus();
	/**
	 * �����˵�
	 * @return
	 */
	public void createMenu(Menu menu);
	
	/**
	 * �޸Ĳ˵�
	 * @return
	 */
	public void editMenu(Menu menu);
	
	/**
	 * ɾ���˵�
	 */
	public void removeMenu(Menu menu);
}
