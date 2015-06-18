package com.hjs.study.spring.test.redis;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 1、redis 3以下不支持分布式集群，但可以通过主从配置实现
 * 	读写分离：数据写入主服务器：192.168.11.35:6379,reids自动复制到子服务器：192.168.11.35:6381(配置文件中需要配置slaveof)
 * 
 * 2、使用ShardedJedisPool对数据进行切片存储，根据key保存到不同的实例中
 */
public class RedisConnPool {
	
	private static Jedis jedisA = null;
	private static Jedis jedisB = null;
	private static Jedis jedisC = null;
	private static ResourceBundle bundle;
	private static JedisPoolConfig config;
	private static ShardedJedisPool npool = null; 
	
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

		//服务器信息
		String hostA = bundle.getString("redis-m.ip");
		Integer portA = Integer.valueOf(bundle.getString("redis-m.port"));
		String hostB = bundle.getString("redis-s.ip");
		Integer portB = Integer.valueOf(bundle.getString("redis-s.port"));
		String hostC = bundle.getString("redis-c.ip");
		Integer portC = Integer.valueOf(bundle.getString("redis-c.port"));
		
		JedisShardInfo jedisShardInfoA = new JedisShardInfo(hostA,portA,"masterA");
		JedisShardInfo jedisShardInfoC = new JedisShardInfo("192.168.11.35",6382,"masterC");
				
		List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
		list.add(jedisShardInfoA);
		list.add(jedisShardInfoC);
		npool = new ShardedJedisPool(config, list);  
		
		//
		jedisA = new Jedis(hostA,portA);
		jedisB = new Jedis(hostB,portB);	//A的子服务器
		jedisC = new Jedis(hostC,portC);	//另外一个切片实例
	}

	public static void main(String[] args) {
		// 从池中获取一个Jedis对象
		// 散列分布
		// 
		ShardedJedis jedis = npool.getResource();
		jedisA.flushDB();
		jedisB.flushDB();
		jedisC.flushDB();
		
		jedis.set("name", "zhangsan-new");
		jedis.set("home", "hangzhou-new");
		jedis.set("age","16-new");
		
		/**
		 * ShardedJedis set内容时，根据传入的key做一致性哈希算法，将值散列的存放到ShardedJedisPool配置的服务器上。
		 * ShardedJedis get内容时，将综合ShardedJedisPool配置的服务器，将值互补并取出
		 */
		System.out.println("slaveofA:	"+jedisB.get("name")+"	"+jedisB.get("home")+"	"+jedisB.get("age"));	//读写分离：从子服务器中读取数据
		System.out.println("分片的另一个实例:	"+jedisC.get("name")+"	"+jedisC.get("home")+"	"+jedisC.get("age"));
		System.out.println("SharedJedis："+jedis.get("name")+"	"+jedis.get("home")+"	"+jedis.get("age"));
		// 释放对象池
		npool.returnResource(jedis);
	}
}
