package com.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.common.pojo.EasyUITreeNode;
import com.e3mall.service.ItemCatService;

/**
 * 商品类目控制器
 * <p>Title: ItemCatController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 下午2:03:42</p>
 * @version 1.0
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 初始化商品类目树
	 * <p>Title: getItemCatList</p>
	 * <p>@date 2019年4月24日 下午2:04:02</p>
	 * @param parentId
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		//指定业务,查询商品类目信息
		List<EasyUITreeNode> list = itemCatService.getCatList(parentId);
		return list;
	}
}
