package com.hjs.study.spring.service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.hjs.study.spring.bean.Menu;
import com.hjs.study.spring.dao.IMenuDao;
import com.hjs.study.spring.service.IMenuService;

import javax.annotation.*;

@Service
public class MenuServiceImpl implements IMenuService{

	@Resource
	private IMenuDao menuDao;
	
	public String getAllMenus() {
		List<Menu> menuList = menuDao.queryMainMenus();
		JSONArray array = JSONArray.fromObject(menuList);
		String x = array.toString();
		
		return x;
	}

	public void createMenu(Menu menu) {
		menuDao.createMenu(menu);
	}

	public void editMenu(Menu menu) {
		menuDao.editMenu(menu);
	}

	public void removeMenu(Menu menu) {
		menuDao.deleteMenu(menu);
	}
}
