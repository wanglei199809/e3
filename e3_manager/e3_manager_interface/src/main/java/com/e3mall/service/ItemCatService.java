/**
 * <p>Title: ItemCatService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 下午1:58:26</p>
 * @version 1.0
 */
package com.e3mall.service;

import java.util.List;

import com.e3mall.common.pojo.EasyUITreeNode;

/**
 * 商品类目服务
 * <p>Title: ItemCatService</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 下午1:58:26</p>
 * @version 1.0
 */
public interface ItemCatService {
	/**
	 * 获取商品类目信息
	 * <p>Title: getCatList</p>
	 * <p>@date 2019年4月24日 下午1:58:51</p>
	 * @param parentId
	 */
	public List<EasyUITreeNode> getCatList(long parentId);
}
