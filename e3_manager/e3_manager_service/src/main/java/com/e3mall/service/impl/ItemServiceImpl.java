/**
 * <p>Title: ItemServiceImpl.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:43:25</p>
 * @version 1.0
 */
package com.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 商品管理Service
 * <p>
 * Title: ItemServiceImpl
 * </p>
 * <p>
 * 
 * @author WangLei
 *         </p>
 *         <p>
 * @date 2019年4月21日 下午4:43:25
 *       </p>
 * 
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

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

}
