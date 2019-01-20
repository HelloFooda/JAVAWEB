package com.shero.dao;

import java.util.List;

import java.util.Vector;

import com.shero.pojo.ShoppingCart;
import com.shero.pojo.PageObject;


public interface ShoppingCartDao {

	///根据购物车状态，用户id查询购物�?
	public Vector<ShoppingCart> getAppointedGoods(int uid, int status)throws Exception;
	//根据用户id获取�?有的商品
	public Vector<ShoppingCart> getAllGoods(int uid)throws Exception;
	//根据购物车状态，商品id，用户id查询购物�?
	public ShoppingCart getGoodsId(int uid, int gid, int status)throws Exception;
	//根据购物车状态，商品id，用户id删除购物�?
	public int deleteGoods(int gid, int uid, int status)throws Exception;
	//根据用户id，购物车状�?�删除购物车
	public int deleteAll(int uid, int status)throws Exception;
	//添加购物�?
	public int addBus(int gid, int uid, int number)throws Exception;
	//修改购物车信�?
	public int updatebus(int id, int number, int status)throws Exception;
	//更新购物车信�?
	public int updateShopcarts(String ids,int status) throws Exception;
	//购物车的分页对象
	public PageObject getPageObject(String curPage,PageObject pageObject,List<Object> listObject);

}
