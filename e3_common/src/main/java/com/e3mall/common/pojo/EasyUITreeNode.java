package com.e3mall.common.pojo;

import java.io.Serializable;

/**
 * EasyUi节点树帮助对象
 * <p>Title: EasyUITreeNode</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 下午1:52:22</p>
 * @version 1.0
 */
public class EasyUITreeNode implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = -2989272130761880549L;
	private long id;
	/**
	 * 节点名称
	 */
	private String text;
	/**
	 * 节点状态
	 */
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
