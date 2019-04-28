package com.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页展示控制器
 * <p>Title: IndexController</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月28日 下午8:23:48</p>
 * @version 1.0
 */
@Controller
public class IndexController {

	/**
	 * 跳转到首页
	 * <p>Title: showIndex</p>
	 * <p>@date 2019年4月28日 下午8:23:58</p>
	 */
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
}
