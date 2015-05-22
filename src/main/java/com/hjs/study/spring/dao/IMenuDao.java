package com.hjs.study.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjs.study.spring.bean.Menu;

@Repository
public interface IMenuDao {

	/**
	 * 查询一级目录
	 */
	public List<Menu> queryMainMenus();
	
	/**
	 * 新增
	 */
	public void createMenu(Menu menu);
	
	/**
	 * 修改
	 */
	public void editMenu(Menu menu);
	/**
	 * 删除
	 */
	public void deleteMenu(Menu menu);
}
