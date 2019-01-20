package com.shero.service;

import java.util.Vector;


import com.shero.dao.GoodsDao;
import com.shero.db.DAOFactory;
import com.shero.db.DBConnection;
import com.shero.pojo.Goods;
import com.shero.pojo.PageObject;

public class GoodsServiceImpl implements GoodsService{
	private DBConnection dbconn = null; // 定义数据库连接类
	private GoodsDao dao = null; // 声明DAO对象
	
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public GoodsServiceImpl() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = DAOFactory.getGoodDAOInstance(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}

	@Override
	public PageObject queryByPage(int curPage, int pageSize) throws Exception {
		PageObject pageObject=null;
		try {
			//创建pageObject对象，用于封装分页数据
			pageObject=new PageObject(curPage,pageSize);
			//调用DAO方法进行查询
			Vector<Goods> gVector=dao.queryByPage(pageObject.getBeginPoint(), pageObject.getPageSize());
			pageObject.setData(gVector);
			//获取数据库记录总数
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
