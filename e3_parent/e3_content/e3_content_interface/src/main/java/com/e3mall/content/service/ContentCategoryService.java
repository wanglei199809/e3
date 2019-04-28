/**
 * <p>Title: ContentCategoryService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午10:29:34</p>
 * @version 1.0
 */
package com.e3mall.content.service;

import java.util.List;

import com.e3mall.common.pojo.EasyUITreeNode;

/**
 * 商品分类管理接口
 * <p>Title: ContentCategoryService</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午10:29:34</p>
 * @version 1.0
 */
public interface ContentCategoryService {
	/**
	 * 通过类编号获取分类列表信息
	 * <p>Title: getContentCategoryList</p>
	 * <p>@date 2019年4月28日 下午10:30:22</p>
	 * @param parentId
	 */
	public List<EasyUITreeNode> getContentCategoryList(Long parentId);
}
