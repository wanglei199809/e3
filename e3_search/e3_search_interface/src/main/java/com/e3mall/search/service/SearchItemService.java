/**
 * <p>Title: SearchItemService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年5月1日 下午5:02:57</p>
 * @version 1.0
 */
package com.e3mall.search.service;

import com.e3mall.common.pojo.E3Result;

/**
 * 商品查询服务
 * <p>Title: SearchItemService</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年5月1日 下午5:02:57</p>
 * @version 1.0
 */
public interface SearchItemService {
	/**
	 * 导入商品信息到索引库
	 * <p>Title: importItmes</p>
	 * <p>@date 2019年5月1日 下午5:03:17</p>
	 * @return
	 */
	public E3Result importItmes(); 
}
