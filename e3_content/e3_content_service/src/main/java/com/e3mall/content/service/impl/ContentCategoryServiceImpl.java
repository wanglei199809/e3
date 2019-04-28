/**
 * <p>Title: ContentCategoryServiceImpl.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午10:32:07</p>
 * @version 1.0
 */
package com.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUITreeNode;
import com.e3mall.content.service.ContentCategoryService;
import com.e3mall.mapper.TbContentCategoryMapper;
import com.e3mall.pojo.TbContentCategory;
import com.e3mall.pojo.TbContentCategoryExample;
import com.e3mall.pojo.TbContentCategoryExample.Criteria;

/**
 * 商品分类信息服务
 * <p>Title: ContentCategoryServiceImpl</p>
 * <p>@author WangLei</p>
 * <p>@date 2019年4月28日 下午10:32:07</p>
 * @version 1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	/*
	 * @see
	 * com.e3mall.content.service.ContentCategoryService#getContentCategoryList(
	 * java.math.BigInteger)
	 */
	@Override
	public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
		// 1、取查询参数id，parentId
		// 2、根据parentId查询tb_content_category，查询子节点列表。
		TbContentCategoryExample example = new TbContentCategoryExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		// 3、得到List<TbContentCategory>
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		// 4、把列表转换成List<EasyUITreeNode>ub
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");
			// 添加到列表
			resultList.add(node);
		}
		return resultList;

	}

	/* 
	 * @see com.e3mall.content.service.ContentCategoryService#insertContentCategory(java.lang.Long, java.lang.String) 
	 */
	@Override
	public E3Result insertContentCategory(Long parentId, String name) {
		//创建一个TbContentCategory对象
		TbContentCategory category = new TbContentCategory();
		//补全TbContentCategory对象的属性
		category.setIsParent(false);
		category.setParentId(parentId);
		category.setName(name);
		//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		category.setSortOrder(1);
		//状态。可选值:1(正常),2(删除)
		category.setStatus(1);
		category.setCreated(new Date());
		category.setUpdated(new Date());
		//向tb_content_category插入一条数据
		contentCategoryMapper.insertSelective(category);
		//判断父节点的isparent是否为true,如果为fase,改为true
		TbContentCategory parentNode = contentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		//返回带插入主键的节点信息
		return E3Result.ok(category);
	}

}
