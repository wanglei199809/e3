/**
 * <p>Title: ContentService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:31:50</p>
 * @version 1.0
 */
package com.e3mall.content.service;

import com.e3mall.common.pojo.EasyUIDataGridResult;

/**
 * 商品内容服务
 * <p>Title: ContentService</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:31:50</p>
 * @version 1.0
 */
public interface ContentService {

	/**
	 * 分页查询商品内容
	 * <p>Title: getContentList</p>
	 * <p>@date 2019年4月29日 上午3:34:12</p>
	 * @param categoryId
	 * @param page
	 * @param rows
	 */
	EasyUIDataGridResult getContentList(Long categoryId, Integer page, Integer rows);

}
