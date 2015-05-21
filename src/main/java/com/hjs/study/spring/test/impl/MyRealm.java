package com.hjs.study.spring.test.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * 自定义Realm 
 * 项目中一般继承 AuthorizingRealm即可
 * @author Administrator
 *
 */
public class MyRealm implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		System.out.println("coming");
		String username = (String)token.getPrincipal(); //得到用户名
		String password = new String((char[])token.getCredentials()); //得到密码
		if(!"zhang".equals(username)) {
		throw new UnknownAccountException("用户名错误"); //如果用户名错误
		}
		if(!"123456".equals(password)) {
		throw new IncorrectCredentialsException("密码错误"); //如果密码错误
		}
		//如果身份认证验证成功，返回一个 AuthenticationInfo 实现；
		return new SimpleAuthenticationInfo(username, password, getName());
	}

	@Override
	public String getName() {

		return MyRealm.class.getName();
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		
		return token instanceof UsernamePasswordToken;
	}

}
