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

import com.e3mall.common.pojo.EasyUIDataGridResult;
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
public class ItemController {
	
	/**
	 * 商品服务
	 */
	@Autowired
	private ItemService itemService;
	
	/**
	 * 通过id获取商品信息
	 * <p>Title: getTbItemById</p>
	 * <p>@date 2019年4月24日 下午1:12:21</p>
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value="/getItemById/{itemId}")
	@ResponseBody
	public TbItem getTbItemById(@PathVariable Long itemId){
		TbItem item = itemService.queryTbItemById(itemId);
		return item;
	}
	
	/**
	 * 查询商品列表
	 * <p>Title: queryItemList</p>
	 * <p>@date 2019年4月24日 下午1:12:08</p>
	 * @param page
	 * @param rows
	 */
	@RequestMapping(value="/item/list")
	@ResponseBody
	public EasyUIDataGridResult queryItemList(Integer page,Integer rows){
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * 查询商品规格参数
	 * <p>Title: queryItemParmList</p>
	 * <p>@date 2019年4月24日 下午1:15:32</p>
	 */
	@RequestMapping(value="/item/param/list")
	@ResponseBody
	public EasyUIDataGridResult queryItemParmList(Integer page,Integer rows){
		EasyUIDataGridResult result = itemService.getItemParamList(page,rows);
		return result;
	}
}
