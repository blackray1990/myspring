package com.hjs.study.spring.test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("10.200.104.24",6379);	//�����ַ�Ͷ˿�
		jedis.set("redis-version", "2");
		System.out.println("redis�汾:"+jedis.get("redis-version"));
		
		jedis.append("redis-version", ".0.2");
		System.out.println("redis�汾:"+jedis.get("redis-version"));
//		jedis.decr("redis-version");
		
		jedis.close();
		
		System.exit(0);
	}
}
