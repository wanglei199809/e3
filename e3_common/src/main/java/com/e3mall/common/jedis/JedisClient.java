package com.e3mall.common.jedis;

/**
 * redis客户端操作接口
 * <p>Title: JedisClient</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月30日 下午11:23:59</p>
 * @version 1.0
 */
public interface JedisClient {

	String set(String key, String value);
	String get(String key);
	Boolean exists(String key);
	Long expire(String key, int seconds);
	Long ttl(String key);
	Long incr(String key);
	Long hset(String key, String field, String value);
	String hget(String key, String field);
	Long hdel(String key, String... field);
}
