package com.hjs.study.spring.test.redis;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import org.junit.Test;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * jredis用法
 * @author Administrator
 *
 */
public class RedisConnPool {
	
	private static JedisPool pool=null;
	private static ResourceBundle bundle;
	private static JedisPoolConfig config;
	
	//静态代码块中初始化代码
	static {
		bundle = ResourceBundle.getBundle("redis");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[redis.properties] 没有找到文件!");
		}
		config = new JedisPoolConfig();
		config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
		config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait"))*1000);
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));

	}
	
	//
/*	public static void testRedis(){
		pool = new JedisPool(config, bundle.getString("redis-s.ip"),
				Integer.valueOf(bundle.getString("redis-s.port")));
		// 从池中获取一个Jedis对象
				Jedis jedis = null;
				try{
					jedis = pool.getResource();
				}catch(Exception e){
					pool.returnBrokenResource(jedis);	//释放redis对象
					e.printStackTrace();
				}
				
				String keys = "name";

				// 删数据
//				jedis.del(keys);
				// 存数据
//				jedis.set(keys, "BlackRay");
				// 取数据
				String value = jedis.get(keys);

				System.out.println("name: "+value);
				System.out.println("lover: "+jedis.get("lover"));

				// 释放对象池
				pool.returnResource(jedis);
	}*/
	
	
	public static void main(String[] args) {
		
		//服务器信息
		JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle.getString("redis-s.ip"), Integer.valueOf(bundle.getString("redis-s.port")));
		JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle.getString("redis-m.ip"), Integer.valueOf(bundle.getString("redis-m.port")));
		jedisShardInfo2.setPassword("foobared");	//如果有密码需要设置密码，否则报ERR operation not permitted
		
		List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
		list.add(jedisShardInfo1);
		list.add(jedisShardInfo2);
		
		
		ShardedJedisPool npool = new ShardedJedisPool(config, list);  
		
		// 从池中获取一个Jedis对象
		ShardedJedis jedis = npool.getResource();
		String keys = "name";
		String value = "blackray";

		jedis.set(keys, value);
		jedis.set("home", "雅阳镇福船村25号--");
		jedis.set("age", "25--");
		
//		System.out.println(jedis.get("name")+"	"+jedis.get("home")+"	"+jedis.get("age"));
		// 释放对象池
		npool.returnResource(jedis);
		
		System.exit(0);
		
	}
	
	@Test
	public void showValue(){
		//服务器信息
				JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle.getString("redis-s.ip"), Integer.valueOf(bundle.getString("redis-s.port")));
				JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle.getString("redis-m.ip"), Integer.valueOf(bundle.getString("redis-m.port")));
				jedisShardInfo2.setPassword("foobared");	//如果有密码需要设置密码，否则报ERR operation not permitted
				
				List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
				
				list.add(jedisShardInfo1);
				list.add(jedisShardInfo2);
				
				
				ShardedJedisPool npool = new ShardedJedisPool(config, list);  
				
				// 从池中获取一个Jedis对象
				ShardedJedis jedis = npool.getResource();
				
				System.out.println(jedis.get("name")+"	"+jedis.get("home")+"	"+jedis.get("age"));
	}
}
