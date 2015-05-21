package com.hjs.study.spring.support;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjs.study.spring.bean.Menu;
import com.hjs.study.spring.bean.User;
import com.hjs.study.spring.dao.IMenuDao;
import com.hjs.study.spring.dao.IUserDao;

public class TestMultipleDataSource {
	public static void main(String[] args) {
        //初始化ApplicationContext
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        IUserDao userDao = applicationContext.getBean(IUserDao.class);

        IMenuDao menuDao = applicationContext.getBean(IMenuDao.class);
        
        //设置数据源为MySql,使用了AOP测试时请将下面这行注释
        MultipleDataSource.setDataSourceKey("jdbcDataSource");
        List<User> allUser = userDao.getAllUsers();
        System.out.println("allUser: "+allUser);
        
        //设置数据源为SqlServer,使用AOP测试时请将下面这行注释
        MultipleDataSource.setDataSourceKey("extJdbcDataSource");
        List<Menu> allMenu = menuDao.queryMainMenus();
        System.out.println("mainMenus: "+allMenu);
    }
}
