package com.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * EasyUi分页结果对象
 * <p>Title: EasyUIDataGridResult</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年4月24日 上午1:54:10</p>
 * @version 1.0
 */
public class EasyUIDataGridResult implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = -2922175162661105363L;
	/**总页数*/
    private Integer total;
    /**当前页数据*/
    private List<?> rows;

    /**
	 * <p>@date 2019年4月24日 上午2:29:38</p>
	 */
	public EasyUIDataGridResult() {
		super();
	}

	public EasyUIDataGridResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EasyUIDataGridResult(Long total, List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
