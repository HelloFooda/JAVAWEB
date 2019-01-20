package com.shero.pojo;


import java.util.List;

public class PageObject {

	private final int DEFAULT_PAGE_SIZE = 4;// Ĭ����ʾ��¼��

	private final int DEFAULT_CUR_SIZE = 1;// Ĭ�ϵ�ǰҳ
	
	@SuppressWarnings("rawtypes")
	private List data;// �����б�

	private int dataCount;// ��������

	private int pageSize;// ��ʾ��¼��

	private int pageCount;// ��ҳ��

	private int curPage;// ��ǰҳ
	
	private int prePage;//ǰһҳ
	
	private int nextPage;//��һҳ
	
	private boolean first=false;//�Ƿ��ǵ�һҳ
	
	private boolean end=false;//�Ƿ������һҳ
	
	public PageObject(int curPage,int pageSize){
		//���õ�ǰҳ��Ĭ��ֵ
		if (curPage < DEFAULT_CUR_SIZE) {
			this.curPage = DEFAULT_CUR_SIZE;
		}else{
			this.curPage = curPage;
		}
		//����ÿҳ������Ĭ��ֵ
		if (pageSize < 1) {
			this.pageSize = DEFAULT_PAGE_SIZE;
		}else{
			this.pageSize = pageSize;
		}
	}
	
	public void init(int dataCount){
		//������������
		this.dataCount=dataCount;
		//������ҳ��
		if (dataCount > 0) {
			this.pageCount = dataCount % pageSize == 0 ? (dataCount / pageSize) : (dataCount / pageSize + 1);
		}		
		//����first
		if (getCurPage()==1) first=true;
		//����end
		if (getCurPage()>=getPageCount()) end=true;
		//����ǰһҳ
		this.prePage = getFirst()?1:getCurPage()-1;
		//���ú�һҳ
		this.nextPage = getEnd()?getCurPage():getCurPage()+1;
	}

	public int getCurPage() {//��õ�ǰҳ
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

	public int getPageCount() {//���ҳ��
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


	public int getBeginPoint() {//��ȡ��ʼ�����ݵ�
		return (getCurPage() - 1) * getPageSize();
	}


}

