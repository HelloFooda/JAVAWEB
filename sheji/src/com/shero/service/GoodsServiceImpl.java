package com.shero.service;

import java.util.Vector;


import com.shero.dao.GoodsDao;
import com.shero.db.DAOFactory;
import com.shero.db.DBConnection;
import com.shero.pojo.Goods;
import com.shero.pojo.PageObject;

public class GoodsServiceImpl implements GoodsService{
	private DBConnection dbconn = null; // �������ݿ�������
	private GoodsDao dao = null; // ����DAO����
	
	// �ڹ��췽����ʵ�������ݿ����ӣ�ͬʱʵ����dao����
	public GoodsServiceImpl() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = DAOFactory.getGoodDAOInstance(this.dbconn.getConnection());// ʵ����GoodDao��ʵ����
	}

	@Override
	public PageObject queryByPage(int curPage, int pageSize) throws Exception {
		PageObject pageObject=null;
		try {
			//����pageObject�������ڷ�װ��ҳ����
			pageObject=new PageObject(curPage,pageSize);
			//����DAO�������в�ѯ
			Vector<Goods> gVector=dao.queryByPage(pageObject.getBeginPoint(), pageObject.getPageSize());
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
	public Vector<Goods> queryGoodBySid(int sid) throws Exception {
		Vector<Goods> goodVector = new Vector<Goods>();
		try {
			goodVector = this.dao.queryGoodBySid(sid);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return goodVector;
	}

}
