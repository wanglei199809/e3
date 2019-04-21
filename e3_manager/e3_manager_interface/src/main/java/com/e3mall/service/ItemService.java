/**
 * <p>Title: ItemService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:29:21</p>
 * @version 1.0
 */
package com.e3mall.service;

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
}