/**
 * <p>Title: TestClient.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月30日 下午11:11:58</p>
 * @version 1.0
 */
package com.e3mall.jedisClient;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.e3mall.common.jedis.JedisClient;
import com.e3mall.common.jedis.JedisClientCluster;

/**
 * jedis连接redis单机和集群测试
 * <p>Title: TestClient</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月30日 下午11:11:58</p>
 * @version 1.0
 */
public class TestClient {
	
	/**
	 * 单机版
	 * <p>Title: testJedisClient</p>
	 * <p>@date 2019年4月30日 下午11:29:28</p>
	 * @throws Exception
	 */
	@Test
	public void testJedisClient() throws Exception {
		//初始化Spring容器
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_redis.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("first", "小明");
		String result = jedisClient.get("first");
		System.out.println(result);
	}
	
	/**
	 * redis集群版测试
	 * <p>Title: testJedisClientCluster</p>
	 * <p>@date 2019年4月30日 下午11:29:44</p>
	 * @throws Exception
	 */
	@Test
	public void testJedisClientCluster() throws Exception {
		//初始化Spring容器
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_redis.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClientCluster.class);
		jedisClient.set("first", "abcd");
		String result = jedisClient.get("first");
		System.out.println(result);
	}
}
