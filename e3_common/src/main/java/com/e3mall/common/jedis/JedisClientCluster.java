package com.e3mall.common.jedis;

import redis.clients.jedis.JedisCluster;
/**
 * redis集群连接工具 jedis客户端接口实现
 * <p>Title: JedisClientCluster</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月30日 下午11:24:35</p>
 * @version 1.0
 */
public class JedisClientCluster implements JedisClient {
	
	/**
	 * redis集群客户端,动态注入,注意需要提供get和set方法
	 */
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key, field);
	}

	/**
	 * @return the jedisCluster
	 */
	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	/**
	 * @param jedisCluster the jedisCluster to set
	 */
	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}
	
}
