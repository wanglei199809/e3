/**
 * <p>Title: ItemServiceImpl.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:43:25</p>
 * @version 1.0
 */
package com.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.common.utils.IDUtils;
import com.e3mall.mapper.TbItemDescMapper;
import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemDesc;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>@author WangLei</p>
 * <p>@date 2019年4月21日 下午4:43:25</p>
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;

	/*
	 * @see com.e3mall.service.ItemService#queryTbItemById(java.lang.Long)
	 */
	@Override
	public TbItem queryTbItemById(Long id) {
		// 根据主键查询
		// return itemMapper.selectByPrimaryKey(id);

		// 第二种,通过example来查询 这个用在这里有点傻
		TbItemExample itemExample = new TbItemExample();
		Criteria criteria = itemExample.createCriteria();
		// 设置查询条件
		criteria.andIdEqualTo(id);
		// 执行业务方法
		List<TbItem> items = itemMapper.selectByExample(itemExample);
		if (items != null && items.size() > 0) {
			return items.get(0);
		} else {
			return null;
		}
	}

	/*
	 * @see
	 * com.e3mall.service.ItemService#getItemList(java.lang.Integer,java.lang.
	 * Integer)
	 */
	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);

		// 创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult(pageInfo.getTotal(), list);

		return result;

	}

	/* 
	 * @see com.e3mall.service.ItemService#getItemParamList(java.lang.Integer, java.lang.Integer) 
	 */
	@Override
	public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		//TbItemParamExample example = new TbItemParamExample();
		
		//取分页信息
		
		//创建返回结果对象
		return null;
	}

	/* 
	 * @see com.e3mall.service.ItemService#addItem(com.e3mall.pojo.TbItem, java.lang.String) 
	 */
	@Override
	public E3Result addItem(TbItem item, String desc) {
		// 1、生成商品id
		long itemId = IDUtils.genItemId();
		// 2、补全TbItem对象的属性
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 3、向商品表插入数据
		itemMapper.insert(item);
		// 4、创建一个TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		// 5、补全TbItemDesc的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		// 6、向商品描述表插入数据
		itemDescMapper.insert(itemDesc);
		// 7、E3Result.ok()
		return E3Result.ok();
	}

}
