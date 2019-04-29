/**
 * <p>Title: ContentController.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:25:32</p>
 * @version 1.0
 */
package com.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.common.pojo.E3Result;
import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.content.service.ContentService;
import com.e3mall.pojo.TbContent;

/**
 * 商品内容控制器
 * <p>Title: ContentController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:25:32</p>
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * 分页查询内容信息
	 * <p>Title: queryContentList</p>
	 * <p>@date 2019年4月29日 下午12:58:13</p>
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/query/list")
	@ResponseBody
	public EasyUIDataGridResult queryContentList(Long categoryId,Integer page,Integer rows){
		return contentService.getContentList(categoryId,page,rows);
	}
	
	/**
	 * 内容保存接口
	 * <p>Title: addContent</p>
	 * <p>@date 2019年4月29日 下午12:58:53</p>
	 * @param tbContent
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public E3Result addContent(TbContent tbContent){
		return contentService.saveContent(tbContent);
	}
	
	/**
	 * 内容编辑接口
	 * <p>Title: editContent</p>
	 * <p>@date 2019年4月29日 下午1:13:19</p>
	 * @param tbContent
	 * @return
	 */
	@RequestMapping(value="/edit")
	@ResponseBody
	public E3Result editContent(TbContent tbContent){
		return contentService.updateContent(tbContent);
	}
}
