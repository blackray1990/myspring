package com.hjs.study.spring.redis;

import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisConnPool {
	
	private static JedisPool pool=null;
	private static ResourceBundle bundle;
	private static JedisPoolConfig config;
	
	//��̬������г�ʼ������
	static {
		bundle = ResourceBundle.getBundle("redis");
		if (bundle == null) {
			throw new IllegalArgumentException(
					"[redis.properties] û���ҵ��ļ�!");
		}
		config = new JedisPoolConfig();
		config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
		config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
		config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait"))*1000);
		config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
		
		pool = new JedisPool(config, bundle.getString("redis-s.ip"),
				Integer.valueOf(bundle.getString("redis-s.port")));
	}
	
	//
	public static void testRedis(){
		// �ӳ��л�ȡһ��Jedis����
				Jedis jedis = null;
				try{
					jedis = pool.getResource();
				}catch(Exception e){
					pool.returnBrokenResource(jedis);	//�ͷ�redis����
					e.printStackTrace();
				}
				
				String keys = "name";

				// ɾ����
//				jedis.del(keys);
				// ������
//				jedis.set(keys, "BlackRay");
				// ȡ����
				String value = jedis.get(keys);

				System.out.println("name: "+value);
				System.out.println("lover: "+jedis.get("lover"));

				// �ͷŶ����
				pool.returnResource(jedis);
	}
	
	
	public static void main(String[] args) {
		
		//��������Ϣ
		JedisShardInfo jedisShardInfo1 = new JedisShardInfo(bundle.getString("redis-s.ip"), Integer.valueOf(bundle.getString("redis-s.port")));
		JedisShardInfo jedisShardInfo2 = new JedisShardInfo(bundle.getString("redis-m.ip"), Integer.valueOf(bundle.getString("redis-m.port")));
		
		
		List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
		list.add(jedisShardInfo1);
		list.add(jedisShardInfo2);
		
		
		ShardedJedisPool npool = new ShardedJedisPool(config, list);  
		
		// �ӳ��л�ȡһ��Jedis����
		ShardedJedis jedis = npool.getResource();
		String keys = "name";
		String value = "blackray";

//		jedis.set(keys, value);
//		jedis.set("home", "�����򸣴���25��");
		String v = jedis.get(keys);

		System.out.println(v+"	"+jedis.get("home")+"	"+jedis.get("age"));

		// �ͷŶ����
		npool.returnResource(jedis);
		
		System.exit(0);
		
	}
}
