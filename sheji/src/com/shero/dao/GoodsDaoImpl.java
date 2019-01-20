package com.shero.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.shero.pojo.Goods;

public class GoodsDaoImpl implements GoodsDao{
	private Connection conn = null; // 数据库连接对象
	private PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 通过构造方法取得数据库连接
	public GoodsDaoImpl(Connection conn) { 
		this.conn = conn;  
	}

	@Override
	public Vector<Goods> queryByPage(int start, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		Vector<Goods> goodVector = new Vector<Goods>();
		String sql = "select gid,gphoto,gname,pdate,gzt from goods limit ?,?";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		pstmt.setInt(1, start);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();//执行数据库操作
		while (rs.next()) { 
			Goods good = new Goods();
			good.setGid(rs.getInt(1));
			good.setGphoto(rs.getString(2));//设定商品照片
			good.setGname(rs.getString(3));//设定商品名称
			good.setPdate(rs.getTimestamp(4));
			good.setGzt(rs.getString(5));
			goodVector.add(good);
		}
		rs.close();
		pstmt.close();
		return goodVector;
	}

	@Override
	public int getCount() throws SQLException {
		int rowCount=0;
		String sql="select count(*) count from goods";
		PreparedStatement pstmt= this.conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			rowCount=rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return rowCount;
	}
	public Vector<Goods> queryGoodBySid(int sid) throws Exception {
		Vector<Goods> goodVector = new Vector<Goods>();
		String sql = "select gid,gname,gphoto,pdate from goods where gid="+sid;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		rs = this.pstmt.executeQuery();//执行数据库操作
		while (rs.next()) { 
			Goods good = new Goods();
			good.setGid(rs.getInt(1));
			good.setGphoto(rs.getString(2));//设定商品照片
			good.setGname(rs.getString(3));//设定商品名称
			good.setPdate(rs.getTimestamp(4));
			good.setGzt(rs.getString(5));
			goodVector.add(good);
		}
		rs.close();
		this.pstmt.close();
		return goodVector;
	}



}
