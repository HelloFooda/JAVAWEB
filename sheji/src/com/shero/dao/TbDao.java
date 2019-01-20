package com.shero.dao;

import java.sql.SQLException;

import java.util.Vector;

import com.shero.pojo.Goods;
import com.shero.pojo.Tb;

public interface TbDao {
	Vector<Tb> queryByPage(int start,int pageSize)throws SQLException;
	int getCount () throws SQLException;
	public int addTb(Tb tb) throws Exception;
	public Vector<Tb> queryTbBytid(int tid) throws Exception;
	
}
