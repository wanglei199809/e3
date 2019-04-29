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

import com.e3mall.common.pojo.EasyUIDataGridResult;
import com.e3mall.content.service.ContentService;

/**
 * 商品内容控制器
 * <p>Title: ContentController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月29日 上午3:25:32</p>
 * @version 1.0
 */
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult queryContentList(Long categoryId,Integer page,Integer rows){
		return contentService.getContentList(categoryId,page,rows);
	}
}
