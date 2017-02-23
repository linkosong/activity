package com.activity.dao.impl;
 
import org.springframework.beans.factory.annotation.Autowired;

import com.activity.dao.RedisClientI;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
 



public class SingleRedisImpl implements RedisClientI {

	@Autowired
	private JedisPool jedisPool;
	
	public String set(String key, String value) {
		//获取dedis的对象
		Jedis jedis = jedisPool.getResource();
		//调用方法
		String string = jedis.set(key, value);
		//释放资源，要不然都拿出来，不放回去，别人就拿不到了。
		jedis.close();
		return string;
	}

	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}

	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}

}
