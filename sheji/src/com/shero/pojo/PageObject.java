package com.shero.pojo;


import java.util.List;

public class PageObject {

	private final int DEFAULT_PAGE_SIZE = 4;// 默认显示记录数

	private final int DEFAULT_CUR_SIZE = 1;// 默认当前页
	
	@SuppressWarnings("rawtypes")
	private List data;// 数据列表

	private int dataCount;// 数据总数

	private int pageSize;// 显示记录数

	private int pageCount;// 总页数

	private int curPage;// 当前页
	
	private int prePage;//前一页
	
	private int nextPage;//后一页
	
	private boolean first=false;//是否是第一页
	
	private boolean end=false;//是否是最后一页
	
	public PageObject(int curPage,int pageSize){
		//设置当前页码默认值
		if (curPage < DEFAULT_CUR_SIZE) {
			this.curPage = DEFAULT_CUR_SIZE;
		}else{
			this.curPage = curPage;
		}
		//设置每页数据量默认值
		if (pageSize < 1) {
			this.pageSize = DEFAULT_PAGE_SIZE;
		}else{
			this.pageSize = pageSize;
		}
	}
	
	public void init(int dataCount){
		//设置数据总数
		this.dataCount=dataCount;
		//设置总页数
		if (dataCount > 0) {
			this.pageCount = dataCount % pageSize == 0 ? (dataCount / pageSize) : (dataCount / pageSize + 1);
		}		
		//设置first
		if (getCurPage()==1) first=true;
		//设置end
		if (getCurPage()>=getPageCount()) end=true;
		//设置前一页
		this.prePage = getFirst()?1:getCurPage()-1;
		//设置后一页
		this.nextPage = getEnd()?getCurPage():getCurPage()+1;
	}

	public int getCurPage() {//获得当前页
		return curPage;
	}

	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}
	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}

	public int getDataCount() {
		return dataCount;
	}

	public int getPageCount() {//获得页数
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	
	public int getPrePage() {
		return prePage;
	}


	public int getNextPage() {
		return nextPage;
	}

	
	public boolean getFirst() {
		return first;
	}


	public boolean getEnd() {
		return end;
	}


	public int getBeginPoint() {//获取开始的数据点
		return (getCurPage() - 1) * getPageSize();
	}


}

