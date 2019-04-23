package com.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 * <p>Title: PageController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 上午1:49:56</p>
 * @version 1.0
 */
@Controller
public class PageController {

	/**
	 * 配置首页跳转
	 * <p>Title: showIndex</p>
	 * <p>@date 2019年4月24日 上午1:42:06</p>
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	/**
	 * 配置页面跳转
	 * <p>Title: showPage</p>
	 * <p>@date 2019年4月24日 上午1:42:21</p>
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
}
