/**
 * <p>Title: TestPageHelp.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 上午2:00:13</p>
 * @version 1.0
 */
package com.e3mall.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>Title: TestPageHelp</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 上午2:00:13</p>
 * @version 1.0
 */
public class TestPageHelp {
	
	//@Test
	public void testPageHelper() throws Exception {
		//初始化spring容器
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_dao.xml");
		//获得Mapper的代理对象
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		//设置分页信息
		PageHelper.startPage(1, 30);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getPageNum());
		System.out.println(pageInfo.getPageSize());
	}

}
