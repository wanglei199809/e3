package com.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e3mall.content.service.ContentService;
import com.e3mall.pojo.TbContent;

/**
 * 首页展示控制器
 * <p>Title: IndexController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午8:23:48</p>
 * @version 1.0
 */
@Controller
public class IndexController {
	
	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;

	/**
	 * 跳转到首页
	 * <p>Title: showIndex</p>
	 * <p>@date 2019年4月28日 下午8:23:58</p>
	 */
	@RequestMapping("/index")
	public String showIndex(Model model) {
		//查询内容列表
		List<TbContent> ad1List = contentService.getContentListById(CONTENT_LUNBO_ID);
		//设置轮播图信息
		model.addAttribute("ad1List", ad1List);
		return "index";
	}
}
