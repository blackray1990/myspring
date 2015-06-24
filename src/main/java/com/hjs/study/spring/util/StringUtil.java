package com.hjs.study.spring.util;

public class StringUtil {

	public static boolean isNotEmpty(String content){
		if(content!=null&&!content.equals("")){
			return true;
		}
		return false;
	}
}
