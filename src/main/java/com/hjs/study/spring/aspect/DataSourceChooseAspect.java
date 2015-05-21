package com.hjs.study.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hjs.study.spring.support.MultipleDataSource;

@Component
@Aspect
public class DataSourceChooseAspect {
	@Pointcut("execution(* com.hjs.study.spring.dao.*.*(..))")
	public void andMethod(){}
	
	@Around("execution(* com.hjs.study.spring.dao.*.*(..))")
    public Object turnToDefaultDataSource(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setDataSourceKey("jdbcDataSource");
        return jp.proceed();
    }
	
    @Around("execution(* com.hjs.study.spring.ext.dao.*.*(..))")
    public Object turnToExtDataSource(ProceedingJoinPoint jp) throws Throwable {
        MultipleDataSource.setDataSourceKey("extJdbcDataSource");
        return jp.proceed();
    }
}
