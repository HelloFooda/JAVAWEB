package com.shero.service;

import java.util.Vector;

import com.shero.pojo.PageObject;
import com.shero.pojo.Tb;

public interface TbService {
	PageObject queryByPage(int curPage,int pageSize)throws Exception;
	public Vector<Tb> queryTbBytid(int tid) throws Exception;
	public int addTb(Tb tb) throws Exception;
}
