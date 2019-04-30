/**
 * <p>Title: ContentServiceImpl.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:35:15</p>
 * @version 1.0
 */
package com.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.Log;
import com.e3mall.common.jedis.JedisClient;
import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.common.utils.JsonUtils;
import com.e3mall.content.service.ContentService;
import com.e3mall.mapper.TbContentMapper;
import com.e3mall.pojo.TbContent;
import com.e3mall.pojo.TbContentExample;
import com.e3mall.pojo.TbContentExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>Title: ContentServiceImpl</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:35:15</p>
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${CONTENT_LIST}")
	private String CONTENT_LIST;

	/* 
	 * @see com.e3mall.content.service.ContentService#getContentList(java.lang.Long, java.lang.Integer, java.lang.Integer) 
	 */
	@Override
	public EasyUIDataGridResult getContentList(Long categoryId, Integer page, Integer rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询,并设置查询条件
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = contentMapper.selectByExample(example);
		// 取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);

		// 创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult(pageInfo.getTotal(), list);

		return result;
	}

	/* 
	 * @see com.e3mall.content.service.ContentService#saveContent(com.e3mall.pojo.TbContent) 
	 */
	@Override
	public E3Result saveContent(TbContent tbContent) {
		try {
			//设置保存时间和修改时间
			tbContent.setCreated(new Date());
			tbContent.setUpdated(new Date());
			//执行保存操作
			contentMapper.insert(tbContent);
			//缓存同步,删除缓存中对应的数据
			jedisClient.hdel(CONTENT_LIST, tbContent.getCategoryId().toString());
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(500, "发生系统错误!");
		}				
		return E3Result.ok();
	}

	/* 
	 * @see com.e3mall.content.service.ContentService#updateContent(com.e3mall.pojo.TbContent) 
	 */
	@Override
	public E3Result updateContent(TbContent tbContent) {
		try {
			//设置修改时间
			tbContent.setUpdated(new Date());
			//执行业务方法
			contentMapper.updateByPrimaryKey(tbContent);
			//缓存同步,删除缓存中对应的数据
			jedisClient.hdel(CONTENT_LIST, tbContent.getCategoryId().toString());
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(500, "系统错误");
		}
		return E3Result.ok();
	}

	/* 
	 * @see com.e3mall.content.service.ContentService#deleteBatchContentByIds(java.util.List) 
	 */
	@Override
	public E3Result deleteBatchContentByIds(ArrayList<String> ids) {
		try {
			if (!ids.isEmpty()) {
				//获取内容id
				Long id = new Long(ids.get(0));
				//查询出对应cid
				TbContent tbContent = contentMapper.selectByPrimaryKey(id);
				
				//执行批量删除业务
				contentMapper.deleteBatchById(ids);		
				
				//缓存同步,删除缓存中对应的数据
				jedisClient.hdel(CONTENT_LIST, tbContent.getCategoryId().toString());				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(500, "系统错误");
		}
		return E3Result.ok();
	}

	/* 
	 * @see com.e3mall.content.service.ContentService#getContentListById(java.lang.Long) 
	 */
	@Override
	public List<TbContent> getContentListById(Long cid) {
		List<TbContent> list = null;
		try {		
			//查询缓存
			String json = jedisClient.hget(CONTENT_LIST, cid + "");
			//判断json是否为空
			if (StringUtils.isNotBlank(json)) {
				//把json转换成list
				list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
			
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			//设置查询条件
			criteria.andCategoryIdEqualTo(cid);
			//执行查询
			list = contentMapper.selectByExampleWithBLOBs(example);
			
			//向集合中添加缓存
			jedisClient.hset(CONTENT_LIST, cid + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}
}
