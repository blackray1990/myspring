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
 * �Զ���Realm 
 * ��Ŀ��һ��̳� AuthorizingRealm����
 * @author Administrator
 *
 */
public class MyRealm implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		System.out.println("coming");
		String username = (String)token.getPrincipal(); //�õ��û���
		String password = new String((char[])token.getCredentials()); //�õ�����
		if(!"zhang".equals(username)) {
		throw new UnknownAccountException("�û�������"); //����û�������
		}
		if(!"123456".equals(password)) {
		throw new IncorrectCredentialsException("�������"); //����������
		}
		//��������֤��֤�ɹ�������һ�� AuthenticationInfo ʵ�֣�
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
