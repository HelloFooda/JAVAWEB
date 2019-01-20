package com.shero.service;

import java.util.Vector;

import com.shero.pojo.Goods;
import com.shero.pojo.PageObject;

public interface GoodsService {
	PageObject queryByPage(int curPage,int pageSize)throws Exception;
	public Vector<Goods> queryGoodBySid(int sid) throws Exception;
}
