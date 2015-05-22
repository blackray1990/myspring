package com.hjs.study.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.hjs.study.spring.support.MultipleDataSource;

@Component
@Aspect
public class DataSourceChooseAspect {
	/**
	 * 切换为默认数据源
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.hjs.study.spring.dao.*.*(..))")
    public Object turnToDefaultDataSource(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setDataSourceKey("jdbcDataSource");
        return jp.proceed();
    }
	/**
	 * 切换为扩展数据源
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
    @Around("execution(* com.hjs.study.spring.ext.dao.*.*(..))")
    public Object turnToExtDataSource(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setDataSourceKey("extJdbcDataSource");
        return jp.proceed();
    }
}
