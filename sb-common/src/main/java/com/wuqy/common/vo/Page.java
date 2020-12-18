/**
 *
 */
package com.wuqy.common.vo;

import java.util.List;

/**
 * @author jiangty
 *
 * @date 2019年2月22日
 */
public class Page<Bean> {

	private List<Bean> rows;

	private long total;

	public Page(List<Bean> rows, long total) {
		this.rows = rows;
		this.total = total;
	}

	public Page() {
	}

	public List<Bean> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public void setRows(final List<Bean> rows) {
		this.rows = rows;
	}

	public void setTotal(final long total) {
		this.total = total;
	}
}
