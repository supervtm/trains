package edu.zime.wzd.domain;

import edu.zime.wzd.util.PropertiesUtils;

/**
 * 分页
 * @author wchvt
 *
 */
public class Page {

	//每页多少数据
	int pageSize = Integer.parseInt(PropertiesUtils.get("size"));
	
	//多少页
	int pageCount;
	
	//数据总数
	int total;
	
	//当前页
	int currentPage = 1;
	
	//数据库中的开始页
	int startPage;
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
}
