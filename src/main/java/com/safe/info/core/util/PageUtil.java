package com.safe.info.core.util;

import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 */
public class PageUtil<T> {
	// 当前页数
	private int pageCurrent;
	// 每页显示数量
	private int pageSize;
	// 总页数
	private int totalPage;
	// 总数量
	private int totalRow;

//	private boolean firstPage=true;
//
//	private boolean lastPage=false;

	private List<T> list;

	// 可以将jui传过来的pageSize、pageNumber进行初始化
	private PageUtil(int pageCurrent, int pageSize) {
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.totalRow = 0;
	}

	// 设置总数量的同时，设置总页数
	public void setCount(int totalRow) {
		this.totalRow = totalRow;
		int temp = 0;
		if (totalRow % this.pageSize != 0) {
			temp++;
		}
		this.totalPage = totalRow / this.pageSize + temp;
	}


	
	//根据map中分页信息生成分页信息
	public static PageUtil pageHelp(int pageCurrent,int pageSize){
		PageUtil page = new PageUtil(pageCurrent,pageSize);//默认每页60
		return page;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
