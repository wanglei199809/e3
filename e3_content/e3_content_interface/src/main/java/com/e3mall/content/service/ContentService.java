/**
 * <p>Title: ContentService.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:31:50</p>
 * @version 1.0
 */
package com.e3mall.content.service;

import java.util.ArrayList;
import java.util.List;

import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.pojo.TbContent;

/**
 * 商品内容服务
 * <p>Title: ContentService</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:31:50</p>
 * @version 1.0
 */
public interface ContentService {

	/**
	 * 分页查询商品内容接口
	 * <p>Title: getContentList</p>
	 * <p>@date 2019年4月29日 上午3:34:12</p>
	 * @param categoryId
	 * @param page
	 * @param rows
	 */
	EasyUIDataGridResult getContentList(Long categoryId, Integer page, Integer rows);

	/**
	 * 内容保存接口
	 * <p>Title: saveContent</p>
	 * <p>@date 2019年4月29日 下午12:59:38</p>
	 * @param tbContent
	 * @return
	 */
	E3Result saveContent(TbContent tbContent);

	/**
	 * 内容编辑服务
	 * <p>Title: updateContent</p>
	 * <p>@date 2019年4月29日 下午1:15:00</p>
	 * @param tbContent
	 * @return
	 */
	E3Result updateContent(TbContent tbContent);

	/**
	 * 内容信息批量删除服务
	 * <p>Title: deleteBatchContentByIds</p>
	 * <p>@date 2019年4月29日 下午1:27:25</p>
	 * @param ids
	 * @return
	 */
	E3Result deleteBatchContentByIds(ArrayList<String> ids);

	/**
	 * 根据内容分类id,查询内容列表
	 * <p>Title: getContentListById</p>
	 * <p>@date 2019年4月29日 下午3:15:50</p>
	 * @param cid
	 */
	List<TbContent> getContentListById(Long cid);

}
