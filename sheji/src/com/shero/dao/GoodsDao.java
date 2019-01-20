package com.shero.dao;

import java.sql.SQLException;

import java.util.Vector;

import com.shero.pojo.Goods;

public interface GoodsDao{
	Vector<Goods> queryByPage(int start,int pageSize)throws SQLException;
	int getCount () throws SQLException;
	public Vector<Goods> queryGoodBySid(int sid) throws Exception;
}
