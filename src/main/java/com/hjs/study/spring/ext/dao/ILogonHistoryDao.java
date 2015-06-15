package com.hjs.study.spring.ext.dao;

import java.util.List;

import com.hjs.study.spring.ext.model.LogonHistory;

public interface ILogonHistoryDao {

	/**
	 * 查询登录历史
	 * @param contition
	 * @return 
	 */
	public List<LogonHistory> selectLogonHistory(LogonHistory contition);
}
