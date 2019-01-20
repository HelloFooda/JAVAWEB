package com.shero.service;

import java.util.Vector;

import com.shero.dao.TbDao;
import com.shero.db.DAOFactory;
import com.shero.db.DBConnection;
import com.shero.pojo.Tb;
import com.shero.pojo.PageObject;

public class TbServiceImpl implements TbService{
	private DBConnection dbconn = null; // 定义数据库连接类
	
	private TbDao dao = null; // 声明DAO对象
	
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public TbServiceImpl() throws Exception { 
		this.dbconn = new DBConnection();
		this.dao = DAOFactory.getTbDAOInstance(this.dbconn.getConnection());// 实例化GoodDao的实现类
	}

	@Override
	public PageObject queryByPage(int curPage, int pageSize) throws Exception {
		PageObject pageObject=null;
		try {
			//创建pageObject对象，用于封装分页数据
			pageObject=new PageObject(curPage,pageSize);
			//调用DAO方法进行查询
			Vector<Tb> gVector=dao.queryByPage(pageObject.getBeginPoint(), pageObject.getPageSize());
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