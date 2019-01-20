package com.shero.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.shero.pojo.ShoppingCart;
import com.shero.pojo.PageObject;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	private Connection conn = null; // 数据库连接对�?
	private PreparedStatement pstmt = null; // 数据库操作对�?
	
	ResultSet rs = null;
	Vector<ShoppingCart> busVector = new Vector<ShoppingCart>();

	// 通过构�?�方法取得数据库连接
	public ShoppingCartDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	//删除指定的购物车信息
	public int deleteGoods(int gid, int uid,int status) throws Exception{
		String sql = "delete from shoppingcart where uid=? and gid=? and status=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, gid);
		this.pstmt.setInt(3, status);
		result = pstmt.executeUpdate();//执行数据库操�?
		this.pstmt.close(); // 关闭PreparedStatement操作
		 
		return result;
	}
	//根据用户id获取�?有的商品
	public Vector<ShoppingCart> getAllGoods(int uid) throws Exception{
		String sql = "select id,gid,number,status from shoppingcart where uid=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		rs = this.pstmt.executeQuery();//执行数据库操�?
		while (rs.next()) {
			ShoppingCart bus = new ShoppingCart();
			bus.setId(rs.getInt(1));//设定购物车id
			bus.setGid(rs.getInt(2));//设定购物车中商品的ID
			bus.setUid(uid);//设定购物车中用户的id
			bus.setNumber(rs.getInt(3));//设定购物车中商品的数�?
			bus.setStatus(rs.getInt(4));//设定购物车的状�??
			busVector.add(bus);
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return busVector;
	}
	//根据购物车状态，用户id查询购物�?
	public Vector<ShoppingCart> getAppointedGoods(int uid, int status) throws Exception{
		String sql = "select id,gid,number from shoppingcart where uid=? and status=?";
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, status);
		rs = this.pstmt.executeQuery();//执行数据库操�?
		while (rs.next()) {
			ShoppingCart bus = new ShoppingCart();
			bus.setId(rs.getInt(1));//设定购物车id
			bus.setGid(rs.getInt(2));//设定购物车中商品的ID
			bus.setUid(uid);//设定购物车中用户的id
			bus.setNumber(rs.getInt(3));//设定购物车中商品的数�?
			bus.setStatus(status);//设定购物车的状�??
			busVector.add(bus);
		}
		rs.close();
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return busVector;
	}

	public int addBus(int gid, int uid,int number) throws Exception{
		String sql="insert into shoppingcart(uid,gid,number,status) values(?,?,?,0)";
		int result=0;
		this.pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);//设定购物车中用户的ID
		this.pstmt.setInt(2, gid);//设定购物车中商品的ID
		this.pstmt.setInt(3, number);//设定购物车中商品的数�?
		result=this.pstmt.executeUpdate();//执行数据库操�?
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	//修改购物车信�?
	public int updatebus(int id,int number,int status) throws Exception{
		String sql="update shoppingcart set status=?,number=? where id=?";
		int result=0;
		this.pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, status);//设定购物车状�?
		this.pstmt.setInt(2, number);//设定购物车中商品的数�?
		this.pstmt.setInt(3, id);
		result=this.pstmt.executeUpdate();//执行数据库操�?
		this.pstmt.close();//关闭PreparedStatement对象
		return result;
	}
	//更新购物车信�?
	public int updateShopcarts(String ids,int status) throws Exception{
	String sql="update shoppingcart set status="+status+" where 1=1";
		String[] idStrings=ids.split(",");
		for (int i = 0; i < idStrings.length; i++) {
			sql+=" or id="+Integer.valueOf(idStrings[i]);
		}
		int result=0;
		this.pstmt=this.conn.prepareStatement(sql);//获取PreparedStatement对象
		//this.pstmt.setInt(1, status);
		// this.pstmt.setString(2, ids);
		result=this.pstmt.executeUpdate(sql);//执行数据库操�?
		this.pstmt.close();//关闭PreparedStatement对象
		return result;
	}
	//根据购物车状态，商品id，用户id查询购物�?
	public ShoppingCart getGoodsId(int uid, int gid,int status) throws Exception{
		String sql = "select id,number from shoppingcart where uid=? and gid=? and status=?";
		ShoppingCart bus = new ShoppingCart();
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, gid);
		this.pstmt.setInt(3, status);
		rs = this.pstmt.executeQuery();//执行数据库操�?
		if (rs.next()) {
			bus.setId(rs.getInt(1));
			bus.setGid(gid);//设定购物车中商品的ID
			bus.setUid(uid);//设定购物车中用户的ID
			bus.setStatus(status);//设定购物车状�?
			bus.setNumber(rs.getInt(2));//设定购物车中商品的数�?
		}
		rs.close();//关闭ResultSet对象
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return bus;
	}
	//删除�?有的购物车信�?
	public int deleteAll(int uid, int status) throws Exception{
		String sql = "delete from shoppingcart where uid=? and status=?";
		int result = 0;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		this.pstmt.setInt(1, uid);
		this.pstmt.setInt(2, status);
		result = this.pstmt.executeUpdate();//执行数据库操�?
		this.pstmt.close();//关闭PreparedStatement对象
		 
		return result;
	}
	@Override
	public PageObject getPageObject(String curPage, PageObject pageObject, List<Object> listObject) {
		// TODO Auto-generated method stub
		return null;
	}
}
