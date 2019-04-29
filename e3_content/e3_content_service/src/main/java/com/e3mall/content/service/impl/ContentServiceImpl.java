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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUIDataGridResult;
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
			contentMapper.deleteBatchById(ids);
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
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			//设置查询条件
			criteria.andCategoryIdEqualTo(cid);
			//执行查询
			list = contentMapper.selectByExampleWithBLOBs(example);
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}
}
