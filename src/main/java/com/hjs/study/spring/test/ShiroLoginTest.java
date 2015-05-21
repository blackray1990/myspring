package com.hjs.study.spring.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ShiroLoginTest {

	private static Log log = LogFactory.getLog(ShiroLoginTest.class);
	/**
	 * ��Ĭ�ϵ�realmʵ�ִ���
	 * ��ini�˻��ж�ȡ��Ϣ���ж��Ƿ�ɵ�¼
	 */
//	@Test
	public void testLogin(){
		//1����ȡ SecurityManager �������˴�ʹ�� Ini �����ļ���ʼ�� SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
		new IniSecurityManagerFactory("classpath:shiro.ini");
		
		//2���õ� SecurityManager ʵ�� ���󶨸� SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		//3���õ� Subject �������û���/���������֤ Token�����û����/ƾ֤��
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
		
		try {
		//4����¼���������֤
		subject.login(token);
		} catch (AuthenticationException e) {
			log.error("�û�����������");
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼
		//6���˳�
		subject.logout();
	}
	/**
	 * ͨ���Զ���ini Realmʵ����֤
	 * ����Զ���Realm ���shiro-realm.ini
	 */
//	@Test
	public void testMyRealm(){
		//1����ȡ SecurityManager �������˴�ʹ�� Ini �����ļ���ʼ�� SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
		new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		
		//2���õ� SecurityManager ʵ�� ���󶨸� SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		//3���õ� Subject �������û���/���������֤ Token�����û����/ƾ֤��
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
		
		try {
		//4����¼���������֤
		subject.login(token);
		
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼
		//6���˳�
		subject.logout();
	}
	
	/**
	 * ͨ���Զ���JDBC Realmʵ����֤
	 */
//	@Test
	public void testJDBCRealm(){
		//1����ȡ SecurityManager �������˴�ʹ�� Ini �����ļ���ʼ�� SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
		new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		
		//2���õ� SecurityManager ʵ�� ���󶨸� SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		//3���õ� Subject �������û���/���������֤ Token�����û����/ƾ֤��
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1234");
		token.setRememberMe(true);
		
		try {
		//4����¼���������֤
		subject.login(token);
		
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼
		//6���˳�
		subject.logout();
	}
	
//	@After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();		//�˳�ʱ�����Subject���߳� ������´β������Ӱ��
    }
}
