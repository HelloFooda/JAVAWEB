package com.shero.service;

import java.util.Vector;

import com.shero.dao.TbDao;
import com.shero.db.DAOFactory;
import com.shero.db.DBConnection;
import com.shero.pojo.Tb;
import com.shero.pojo.PageObject;

public class TbServiceImpl implements TbService{
	private DBConnection dbconn = null; // �������ݿ�������
	
	private TbDao dao = null; // ����DAO����
	
	// �ڹ��췽����ʵ�������ݿ����ӣ�ͬʱʵ����dao����
	public TbServiceImpl() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = DAOFactory.getTbDAOInstance(this.dbconn.getConnection());// ʵ����GoodDao��ʵ����
	}

	@Override
	public PageObject queryByPage(int curPage, int pageSize) throws Exception {
		PageObject pageObject=null;
		try {
			//����pageObject�������ڷ�װ��ҳ����
			pageObject=new PageObject(curPage,pageSize);
			//����DAO�������в�ѯ
			Vector<Tb> gVector=dao.queryByPage(pageObject.getBeginPoint(), pageObject.getPageSize());
			pageObject.setData(gVector);
			//��ȡ���ݿ��¼����
			pageObject.init(dao.getCount());
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbconn.close();
		}
		return pageObject;
	}
	public int addTb(Tb tb) throws Exception {
		int result = 0;
		try {
			result = this.dao.addTb(tb);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return result;
	}
	public Vector<Tb> queryTbBytid(int tid) throws Exception{
		Vector<Tb> tbVector = new Vector<Tb>();
		try {
			tbVector = this.dao.queryTbBytid(tid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return tbVector;
	}
}