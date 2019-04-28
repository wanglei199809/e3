package com.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.common.pojo.E3Result;
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
	
	/**
	 * 添加商品分类信息
	 * <p>Title: createCategory</p>
	 * <p>@date 2019年4月29日 上午1:11:12</p>
	 * @param parentId 父节点id
	 * @param name 当前节点编号
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public E3Result createCategory(Long parentId,String name){
		E3Result result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	
	/**
	 * 商品分类重命名
	 * <p>Title: updateCategory</p>
	 * <p>@date 2019年4月29日 上午1:35:39</p>
	 * @param id 当前节点id
	 * @param name 界面名称
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public E3Result updateCategory(Long id,String name){
		E3Result result = contentCategoryService.updateContentCategory(id, name);
		return result;
	}
}
