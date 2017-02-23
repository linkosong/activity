package com.activity.dao;
 
/**
 * 定义一个Redis的接口，用于可以同时接受单机版和集群的reids
 * @author 米世廷
 *
 */
public interface RedisClientI {
//----------String 的存取-----------
	
    //返回是OK 
	String set(String key,String value);
	//返回value 的值              取不到返回  null
	String get(String key);
	
//--------------Hash 的存取----------------
	long  hset(String hkey ,String key ,String value); 
	//返回value 的值
	String hget(String hkey,String key);
	
//===============工具类的===========================	
	
	//自增	
	long incr(String key);
	//设置过期时间
	long expire(String key,int second);
	//查看key的过期时间
	long ttl(String key);
	//删除key
	long del(String key);
	//hash 的删除	
	long hdel(String hkey,String key);

}
