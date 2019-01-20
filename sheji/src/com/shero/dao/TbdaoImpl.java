package com.shero.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.shero.pojo.Goods;
import com.shero.pojo.Tb;
import com.shero.pojo.Users;

public class TbdaoImpl implements TbDao{
	
	private Connection conn=null;
	private PreparedStatement pstmt = null;
	ResultSet rs=null;

	public TbdaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public Vector<Tb> queryTbBytid(int tid) throws Exception{
		Vector<Tb> tbVector = new Vector<Tb>();
		String sql = "select tid,uid,tsp,tzw,tbt,tdate from tb where tid="+tid;
		this.pstmt = this.conn.prepareStatement(sql);//获取PreparedStatement对象
		rs = this.pstmt.executeQuery();//执行数据库操作
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Tb tb=new Tb();
			tb.setTid(rs.getInt(1));
			tb.setUid(rs.getInt(2));
			tb.setTdate(rs.getTimestamp(3));
			tb.setTsp(rs.getString(4));
			tb.setTzw(rs.getString(5));
			tb.setTbt(rs.getString(6));
			tbVector.add(tb);
		}
		rs.close();
		pstmt.close();
		return tbVector;
	}
	@Override
	public int addTb(Tb tb) throws Exception {
			String sql = "insert into tb(tbt,tzw,tsp) values(?,?,?,sysdate())";
			int result = 0;
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(2, tb.getTbt());
			pstmt.setString(3, tb.getTzw());
			pstmt.setString(4, tb.getTsp());
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		}
	@Override
	public Vector<Tb> queryByPage(int start, int pageSize) throws SQLException {
		
		Vector<Tb> tbVector = new Vector<Tb>();
		String sql = "select tid,tsp,tzw,tbt,tdate from tb limit ?,?";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Tb tb=new Tb();
			tb.setTid(rs.getInt(1));
			tb.setTsp(rs.getString(2));
			tb.setTzw(rs.getString(3));
			tb.setTbt(rs.getString(4));
			tb.setTdate(rs.getTimestamp(5));
			tbVector.add(tb);
		}
		rs.close();
		pstmt.close();
		return tbVector;
	}

	@Override
	public int getCount() throws SQLException {
		int rowCount=0;
		String sql="select count(*) count from tb";
		PreparedStatement pstmt= this.conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			rowCount=rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return rowCount;
	}
}
