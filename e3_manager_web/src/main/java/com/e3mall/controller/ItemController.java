/**
 * <p>Title: ItemController.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:58:24</p>
 * @version 1.0
 */
package com.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3mall.pojo.TbItem;
import com.e3mall.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月21日 下午4:58:24</p>
 * @version 1.0
 */
@Controller
@RequestMapping(value="/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/getItemById/{itemId}")
	@ResponseBody
	public TbItem getTbItemById(@PathVariable Long itemId){
		TbItem item = itemService.queryTbItemById(itemId);
		return item;
	}
	
}
