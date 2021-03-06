package com.hjs.study.spring.support;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();
	
	//数据源名称
	public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
	
	@Override
	protected Object determineCurrentLookupKey() {
		
		return dataSourceKey.get();
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
