/**
 * <p>Title: ItemService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:29:21</p>
 * @version 1.0
 */
package com.e3mall.service;

import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.pojo.TbItem;

/**
 * 商品业务
 * <p>Title: ItemService</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:29:34</p>
 * @version 1.0
 */
public interface ItemService {
	
	/**
	 * 通过商品id,获取商品信息
	 * <p>Title: geTbItemById</p>
	 * <p>@date 2019年4月21日 下午4:34:18</p>
	 * @param id
	 */
	TbItem queryTbItemById(Long id);

	/**
	 * 分页查询商品信息
	 * <p>Title: getItemList</p>
	 * <p>@date 2019年4月24日 上午2:20:08</p>
	 * @param page
	 * @param rows
	 */
	EasyUIDataGridResult getItemList(Integer page, Integer rows);

	/**
	 * 分页查询商品规格参数信息
	 * <p>Title: getItemParamList</p>
	 * <p>@date 2019年4月24日 下午1:17:38</p>
	 * @param page
	 * @param rows
	 */
	EasyUIDataGridResult getItemParamList(Integer page, Integer rows);
	/**
	 * 添加商品信息
	 * <p>Title: addItem</p>
	 * <p>@date 2019年4月28日 下午6:07:54</p>
	 * @param item
	 * @param desc
	 */
	E3Result addItem(TbItem item, String desc);
}
