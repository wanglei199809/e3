package com.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.common.pojo.EasyUITreeNode;
import com.e3mall.content.service.ContentCategoryService;

/**
 * 商品分类信息控制器
 * <p>Title: ContentCategoryController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午10:45:50</p>
 * @version 1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	/**
	 * 商品分类服务
	 */
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	/**
	 * 商品分类列表
	 * <p>Title: getContentCatList</p>
	 * <p>@date 2019年4月28日 下午10:46:29</p>
	 * @param parentId
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

		List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
		return list;
	}
}
