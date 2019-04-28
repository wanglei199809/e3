/**
 * <p>Title: ContentCategoryService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午10:29:34</p>
 * @version 1.0
 */
package com.e3mall.content.service;

import java.util.List;
import java.util.Map;

import com.e3mall.common.pojo.E3Result;
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
	/**
	 * 添加商品分类信息
	 * <p>Title: insertContentCategory</p>
	 * <p>@date 2019年4月29日 上午12:32:34</p>
	 * @param id
	 * @param name
	 */
	public E3Result insertContentCategory(Long id,String name);
	/**
	 * 重命名商品信息
	 * <p>Title: updateContentCategory</p>
	 * <p>@date 2019年4月29日 上午1:32:51</p>
	 * @param parentId
	 * @param name
	 */
	public E3Result updateContentCategory(Long parentId, String name);
	/**
	 * 根据id删除子节点
	 * <p>Title: deleteContentCategoryById</p>
	 * <p>@date 2019年4月29日 上午1:54:11</p>
	 * @param id
	 */
	public Map<String,String> deleteContentCategoryById(Long id);
}
